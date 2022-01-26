# [Semesteroppgave 2: Fire på rad og Tripp-trapp-tresko]


* **README**
* [Oppgavetekst](SEM-2.md)
* [Tips for å komme i gang](Tips.md)
* [Advanced](Advanced.md)


## Tilbakemelding av TA

Du har god dokumentasjon i README og koden. Bra at du bruker Javadoc, men savner forklaring på variablene i funksjonene (@param output ...)
Bra at du dokuemterer ting som ikke fungere også.
Supert at du har lagd tester for begge Controller'ene.
Selv om MVC ikke akkurat er det man lærer i INF101, synes jeg du har organisert koden veldig godt.



## Oversikt
Har lagt til alle abstraksjonene i GameController, der FourInRowController,  TicTacToeController  og InputOutputController implementerer disse.
I Model mappen finner vi 3 singleton klasser filer, GameModel tar imot informasjon relatert til spillet, Map har karttilstand hele tiden
og Player holder informasjon til spilleren, blant annet bevegelser. Har to Enums filer, som har navnet GameName og GameType. 
Har også laget to interfaces som heter Input og Output, der  InputOutputController bruker disse Interfacene som få regristere det brukeren trykker. Eneste brukeren kommer til å se 
er View filen, som kommuniserer InputOutPutController, for å se hva den skal vise til bruker som spiller. 

### Bruk
For å starte programmet kjør: `Kjør Main.java`  
For å legge ut en brikke må du: `Skriv x og y kordinater, eks 3,2`   
Når du vinner skjer: `Går gjennom Controller, og sjekker om det er en vinner og printer det ut  `
(...etc...)   

## Designvalg
*Snakket med en del studenter og så hvordan de valgte å løse oppgaven, så at de hadde en rot i koden, så jeg prøvde å lage meg en klar plan, 
for hvordan jeg skulle løse denne  oppgaven, valgte jeg å bruke MVC Design Pattern. Der jeg bruker tre main filer, "Controller", "Model" og "View".
 Controller er der input og ouput skjer, og der "logikken" til spillet ligger. 
 "Model" tar imot data som er relevant for spillet, og updater filen "View" som "user" ser. 

### Bruk av abstraksjon
*(hvordan du har valgt objekter/klasser for å representere ting i spillet)
Jeg satte alle abstrakjonene i en klasse, "GameController" 
Der ligger alle abstraksjonene til spillene til tic tac toe og 4 in row.
Fra der overrrider jeg alle abstraksjonene i Tic og 4InRow. Etter at logikken får kjørt seg retunerer de svarene tilbake til GameModel som holder på informasjonen.  
*

### Erfaring – hvilke valg viste seg å være gode / dårlige?
*Kom ikke på hvordan jeg skulle kode en god kode for å sjekke hvordan man vant på tic tac toe, om du ser på method checkForVictory, ser man at det er ganske dårlig kode, der jeg repeterer meg hele tiden.
 Prøvde meg på en annen metode på FourInRow der jeg forlooper for å sjekke om det er 4 på rad, men den får kun sjekket i en Row og ikke diagonalt.
 Burde kanskje ha brukt Enums litt anderledes, men tanken bak den var at vi fikk en "menu" som vi fikk vite. 
  Mer enn det er jeg ganske fornøyd hvordan jeg besvarte oppgaven, har en ganske ryddig kode med organisert mappe fordeling, en klar design pattern som jeg bruker.  

    *

## Testing
Har laget to test filer for både TicTacToe og FourInRow, der jeg sjekker om informasjonen stemmer overens med det som står i GameModel og Map. Har en objekt "g" som peker mot tic/4InRow, som extender fra GameController, og som sjekker om informasjonenen stemmer. 
 
## Funksjonalitet, bugs
hva virker: Nesten alt sammen fungerer. 

virker ikke: Hvordan man vinner på Four in a row, ser ut som ikke å fungerere, har prøvd å implementere hvordan man vinner diagonalt,
 men får det fortsatt ikke til å fungere. Fikk en del feil på starten på hvordan jeg skulle lagre informasjonen i en klasse, men ble overbevist å bruke singleton classes for å ha mer struktur. 



Diagram: https://i.imgur.com/H59unVq.png

