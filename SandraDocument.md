# Documentation 
Sandra Jeppsson Kristiansson - *2023-06-25*

### Projektbeskrivning:

- Skapa en fungerande TODO applikation med CRUD-funktioner *(Create, Read, Update, Delete)*.
- Testa applikationen med JUnit och Mockito
- Vem som helst skall kunna använda och testa applikationen
- Använd GitHub Actions och CI med automatisk testning

### Vad jag har gjort:
- Jag har enligt instruktionerna ovan skapat en applikation där användaren startar programmet och blir ombedd att fylla 
i databasens namn. Därefter får användaren en meny med fem olika val där fyra står för varsin bokstav i "CRUD". Vilken 
man än väljer så börjar dessa med att be användaren om "Table Name". Detta för att ha möjligheten att skapa tabeller med
olika sorters TODO - till exempel *Midsommar, Packa, Städa* etc.

#### DbHandler: 
- __Create__: När man anger *Table Name* så kollar denna metoden först om tabellen redan finns - gör den det så går den 
vidare till att be om "assignment", "assignee" och "done" och en ny TODO skapas. Finns inte tabellen så skapar den 
istället en ny sådan och man blir sedan ombedd att fylla i all TODO-information.
- __Read__: Efter att man angett *Table Name* frågar programmet användaren om man vill läsa en TODO - där man isåfall fyller
i "id" för TODO:n och TODO med matchande ID visas - eller om man vill läsa alla TODOs.Vid sist nämnda får man en lista 
med alla TODOs i tabellen med information om ID, Assignment, Assignee och Done.
- __Update__: Efter att man angett *Table Name* frågar programmet om man vill uppdatera assignment eller uppdatera done. 
Båda startar med att visa en lista på de TODOs som finns i tabellen och man får sedan välja ID för TODO:n som man vill 
uppdatera och därefter fylla i antingen "assignment" eller "done".
- __Delete__: Efter att man angett *Table Name* visar metoden alla TODOs som finns i tabellen. Därefter blir man ombedd 
att skriva in ID för att sedan ta bort matchande TODO. 
#### ..implements *iCrud*:
- Ett gränssnitt(*interface*) med CRUD-funktionalitet. Där Create() och Delete() har boolean som returntyper
  (som i detta fall är anpassade efter testerna) och Read() och Update() är satta till void.
#### User:
- Userklass med attributen int id, String name, int age och List<ToDo> todos men som aldrig fick se ljuset.
#### UserHandler:
- UserFacade som implementerar iCrud och iTable men som aldrig fick se ljuset.
#### iTable:
- Ett gränssnitt(*interface*) med metoderna createTable() och searchForTable() men som aldrig heller fick se ljuset.

### Tester:
- __ToDoTest__: Testar metoderna i ToDo.
- __DbHandlerTest__: Testar 80%+ av metoderna i DbHandler
- __HelperTest__: Testar 80%+ av metoderna i Helper


### Planering 
#### Lösningsförslag: 
#### UML: 
- https://lucid.app/lucidchart/c5d2e1c2-074a-441a-b902-af853513c7e5/edit?view_items=Fmu-GisJSQHb&invitationId=inv_7182489d-9dac-4d32-8231-a060f03ddfb9
##### KanBan:
 - Trello: https://trello.com/invite/b/yxF1AFWT/ATTI1f77fc66dac720ab0653d26db76638b2F992D4CD/todoapplicationwithtesting

### Arbetet och dess genomförande:
#### Vad som varit svårt:
- Något som varit riktigt svårt är att få Mockito att fungera korrekt och trots över två timmar med Marcus på Code With 
Me så kunde vi inte hitta en lösning. Då valde jag att börja om helt med både kod och testning och i viss mån ta hjälp 
av chatGPT. Koden blev verkligen inte alls som jag tänkt eller önskat mig. Ursprungskoden var betydligt vackrare och jag 
hoppades på att kunna fortsätta på den med kodidéer för både fler gränssnitt och superklasser.
- Jag har testat mig fram med lite olika gränssnitt då planen från början var att försöka hinna göra ett fullt program 
med User och UserFacade med eftersom att jag fick börja om så fanns inte tiden till detta. I Facaden(/Handler) hade jag 
tänkt implementera iCrud och även "iTable" som innehåller metoderna för att skapa och söka efter en tabell. Utöver det
tänkte jag även skapa en *Database Super Class* med metoderna "getConnection" och "setConnection" som hade gjort att jag 
i både DBHandler och UserHandler kunnat "extenda" denna och dess anslutning till databasen.
- Att sätta automatiska tester. Satt med min bror som pluggar på Chalmers och som samtidigt jobbar med att både projekt- 
leda och skapa applikationer. Med uppgiften framför oss och "De ENDA moduler som får användas" lista framför oss så
slösade vi två timmar på att försöka skapa automatiska tester utan att använda apache.maven.plugin.

### Reflektioner och slutsatser
##### Vad har gått bra:
- Jag tycker ändå att jag haft många bra idéer längs vägen(se ovan) som jag gärna hade haft tid att implementera i 
applikationen. 
- Jag har fått öva på mitt tålamod?
##### Vad gick dåligt:
- Mockito. För det första att i första versionen hitta alla kryphål och ha 100% mockning av beroenden - där inte tyvärr 
varken jag eller utbildare kunde komma med en lösning på problemet. 
- Att behöva göra om och begränsa sig efter deadline.
##### Vad jag har lärt mig och vad jag hade gjort annorlunda:
- Att använda GitHub actions och vad en YML-fil är
- Att ta ett test och en metod i taget och successivt bygga på testerna.
##### Möjligheter med kurskunskaperna:
- Att veta hur man testar med JUnit och Mockito
- Veta vad det är och hur man skriver/tyder en testrapport

#### Applikation och tester testade av min bror, Daniel Rygaard.

##### Länk aktuellt projekt: https://github.com/Sandra1887/TodoApplicationMock-JUnit
##### Länk första utkast: https://github.com/Sandra1887/TodoProjectWithTests/tree/master/src
    - 