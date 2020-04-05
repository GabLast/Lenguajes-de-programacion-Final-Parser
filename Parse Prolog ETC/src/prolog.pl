progenitor(antonio, carlos).
progenitor(antonio, eva).
progenitor(maria, eva).
progenitor(maria, carlos).
progenitor(carlos, silvia).
progenitor(carlos, fernando).
progenitor(elena, silvia).
progenitor(elena, fernando).
progenitor(eva, emilio).
progenitor(david, emilio).
padre(pedro, juan).

abuelo(Abuelo,Nieto):-
    progenitor(Abuelo, Padre), progenitor(Padre, Nieto).
