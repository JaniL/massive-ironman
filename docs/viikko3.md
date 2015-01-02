# Viikko 3

Robotti on saatu nyt siihen vaiheeseen että sitä voi alkaa hienosäätää ja viimeistelemään.

Kenkun suunnitelmapalautteen perusteella koodasin robotille ohjelman joka seuraa viivaa. 
Robotti ei kuitenkaan tee suoranaisesti 90 asteen käännöksiä, vaan se etsii viivaa raalla
voimalla kääntymällä hiukan tiettyyn suuntaan.

Robotti aloittaa kääntymällä oikealle. Mikäli viivaa ei löydy oikealta puolelta, robotti
palaa alkuperäiseen kulmaansa ja alkaa kääntyä toiseen suuntaan. Ensimmäisen kääntymisen
jälkeen robotti aloittaa kääntämällä sille puolelle mille se kääntyi viimeksi.
Tällöin robotti suoriutuu paremmin mm. neliöesimerkissä.

Mikäli robotti ei löydä viivaa kummaltakaan puolelta, ohjelma sulkeutuu.

Ohjelma ei tällä hetkellä ole kuitenkaan täydellinen. DifferentialPlotin parametreina on
ihan päästä heitettyjä arvoja, jonka vuoksi astearvot eivät pidä paikkansa todellisuuden
kanssa. Tämän takia robotti voi kääntyä tiettyyn suuntaan hyvin jyrkästi ennen kuin se
tajuaa viivan olevan toisella puolella.

Ohjelman hienosäätö ja refaktorointi ovat nyt työlistalla seuraavana, koska
ohjelman luonti on tähän asti ollut silkkaa prototyyppailua.

Robotin käännöslogiikassa voisi olla myös parantamisen varaa.

Koska neliöreitissä ei hirveämmin käännytä vasemmalle, päädyin tekemään sille uuden reitin:
https://drive.google.com/file/d/0B-VrTeG8QPOBeGhwOGRNeEtYQ2c/view?usp=sharing

[video tulossa myöhemmin]

Robotti neliöreitillä: [video tulossa myöhemmin]
