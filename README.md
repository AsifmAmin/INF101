# [Semesteroppgave 2: Fire på rad og Tripp-trapp-tresko]


* **README**
* [Oppgavetekst](SEM-2.md)
* [Tips for å komme i gang](Tips.md)
* [Advanced](Advanced.md)

**Innleveringsfrist:** Hele oppgaven skal være ferdig og levert via din private gitlab-repositorie til **Fredag 24. april kl. 2359** ([AoE](https://www.timeanddate.com/worldclock/fixedtime.html?msg=4&iso=20180427T2359&p1=3399)).  

### Innlevering 
 Du finner koden din i repositoriet med URIen:

    https://retting.ii.uib.no/<brukernavn>/inf101.v20.sem2.git

Oppgaven leveres inn ved å pushe til retting.ii.uib.no, [slik du har gjort med alle tidligere INF101-oppgaver](https://retting.ii.uib.no/inf101/inf101.v20/wikis/hente-levere-oppgaver). Husk å få med eventuelle nye filer du har opprettet.

**VIKTIG:** *Sjekk kvitteringssiden som kommer opp når du pusher, i tilfelle det skjer feil!* 

Vi anbefaler at du gjør commit hver dag, eller hver gang du er ferdig med en
deloppgave, i tilfelle du mister det du jobber med på din egen maskin. Du kan levere inn så mye og ofte du vil. Versjonen som teller er den **siste du pushet før innleveringsfristen**.

Denne oppgaven teller på din endelige vurdering i faget. Maks poeng er 100. Du kan få opp til 120 totalt, inkludert ekstrapoeng. 

# Fyll inn egne svar/beskrivelse/kommentarer til prosjektet under
* Levert av:   *NAVN* (*BRUKERNAVN*)
* [ ] hele semesteroppgaven er ferdig og klar til retting!
* Code review:
   * [ ] jeg har fått tilbakemelding underveis fra @brukernavn, ...
   * [ ] jeg har gitt tilbakemelding underveis til @brukernavn, ...
* Sjekkliste:
   * [x] Kjørbart Fire på Rad-spill
	   * [X] Funksjonelt spill 
	   * [x] Fungerende user interface
	   * [x] Støtter AI 
   * [X] Kjørbart Tripp-trapp-tresko-spill
	   * [X] Funksjonelt spill 
	   * [X] Fungerende user interface
	   * [X] Støtter AI 
   * [ ] Forklart designvalg, hvordan koden er organisert, abstraksjon, og andre ting 
   * [ ] Tester
   * [ ] Dokumentasjon (JavaDoc, kommentarer, diagrammer, README, etc.)
   * [ ] Fornuftige navn på klasser, interfaces, metoder og variabler
   * [ ] Fornuftige abstraksjoner og innkapsling (bruk av klasser, interface, metoder, etc.)

## Oversikt
*(oversikt over koden din og det du har gjort)*

Har lagt til alle abstraksjonene i GameController, der FourInRowController,  TicTacToeController  og InputOutputController implementerer disse. 
Har også laget to interfaces som heter Input og Output, der  




### Bruk
For å starte programmet kjør: `fyll.inn.her`  
For å legge ut en brikke må du: `Skriv x og y kordinater, eks 3,2`   
Når du vinner skjer: `Går gjennom Controller, og sjekker om det er en vinner og printer det ut  `
(...etc...)   

## Designvalg
*I denne oppgaven, valgte jeg å bruke MVC Design Pattern. Der jeg bruker tre main filer, "Controller", "Model" og "View".
 Controller er der input og ouput skjer, og der logikken til spillet ligger. 
 "Model" tar imot data som er relevant for spillet, og updater filen "View" som "user" ser. 

### Bruk av abstraksjon
*(hvordan du har valgt objekter/klasser for å representere ting i spillet)
Jeg satte alle abstrakjonene i en klasse, "GameController" Der ligger alle abstraksjonene til spillene til tic tac toe og 4 in row. 
*

### Erfaring – hvilke valg viste seg å være gode / dårlige?
*(designerfaringer – er det noe du ville gjort annerledes?)*

## Testing
*(hvordan du har testet ting) 

Jeg sjekker gjennom ved å sjekke om alle statementene er true, der package Map og GameModel innholder alt av data, kan jeg sjekke om det stemmer overens med
Controllene, 
*

## Funksjonalitet, bugs
*(hva virker: Nesten alt sammen fungerer.
 
 virker ikke: Hvordan man vinner på Four in a row, ser ut som ikke å fungerere, har prøvd å implementere hvordan man vinner diagonalt, men får det fortsatt ikke til å fungere.

## Evt. erfaring fra code review
*(lærte du noe av å gå gjennom din eller andres kode?)*

## Annet
*(er det noe du ville gjort annerledes?)*


Diagram: https://i.imgur.com/H59unVq.png
