(define (imc pesoKG alturaM)
  (/ pesoKG (expt alturaM 2)))

(define (porcentajeGrasa pesoKG alturaM edad genero)
  (cond
    ((= genero 0) (paraMujeres pesoKG alturaM edad))
    ((= genero 1) (paraHombres pesoKG alturaM edad))
    (else "Genero invalido")))

(define (paraHombres pesoKG alturaM edad)
  (- (- (+ (* 1.2 (imc pesoKG alturaM)) (* 0.23 edad)) 10.8) 5.4))

(define (paraMujeres pesoKG alturaM edad)
   (- (+ (* 1.2 (imc pesoKG alturaM)) (* 0.23 edad)) 5.4))

(define (caloriasMantenerPeso pesoKG alturaM edad nivelEJ genero)
  (cond
    ((= nivelEJ 1) (sinEj pesoKG alturaM edad genero))
    ((= nivelEJ 2) (pocoEJ pesoKG alturaM edad genero))
    ((= nivelEJ 3) (moderadoEJ pesoKG alturaM edad genero))
    ((= nivelEJ 4) (muchoEJ pesoKG alturaM edad genero))
    ((= nivelEJ 5) (demasiadoEJ pesoKG alturaM edad genero))
    (else "Nivel de Ejercicio invalido")))

(define (sinEJ pesoKG alturaM edad genero)
  (cond
    ((= genero 1) (* (- (+ 66 (* 13.7 pesoKG) (* 5 (* alturaM 100))) (* 6.75 edad)) 1.2))
    ((= genero 0) (* (- (+ 655 (* 9.6 pesoKG) (* 1.8 (* alturaM 100))) (* 4.7 edad)) 1.2))
    (else "Genero invalido")))

(define (pocoEJ pesoKG alturaM edad genero)
  (cond
    ((= genero 1) (* (- (+ 66 (* 13.7 pesoKG) (* 5 (* alturaM 100))) (* 6.75 edad)) 1.375))
    ((= genero 0) (* (- (+ 655 (* 9.6 pesoKG) (* 1.8 (* alturaM 100))) (* 4.7 edad)) 1.375))
    (else "Genero invalido")))

(define (moderadoEJ pesoKG alturaM edad genero)
  (cond
    ((= genero 1) (* (- (+ 66 (* 13.7 pesoKG) (* 5 (* alturaM 100))) (* 6.75 edad)) 1.55))
    ((= genero 0) (* (- (+ 655 (* 9.6 pesoKG) (* 1.8 (* alturaM 100))) (* 4.7 edad)) 1.55))
    (else "Genero invalido")))

(define (muchoEJ pesoKG alturaM edad genero)
  (cond
    ((= genero 1) (* (- (+ 66 (* 13.7 pesoKG) (* 5 (* alturaM 100))) (* 6.75 edad)) 1.72))
    ((= genero 0) (* (- (+ 655 (* 9.6 pesoKG) (* 1.8 (* alturaM 100))) (* 4.7 edad)) 1.72))
    (else "Genero invalido")))

(define (demasiadoEJ pesoKG alturaM edad genero)
  (cond
    ((= genero 1) (* (- (+ 66 (* 13.7 pesoKG) (* 5 (* alturaM 100))) (* 6.75 edad)) 1.9))
    ((= genero 0) (* (- (+ 655 (* 9.6 pesoKG) (* 1.8 (* alturaM 100))) (* 4.7 edad)) 1.9))
    (else "Genero invalido")))


(define (caloriasBajarPeso pesoKG alturaM edad nivelEJ genero)
  (- (caloriasMantenerPeso pesoKG alturaM edad nivelEJ genero) 500))

