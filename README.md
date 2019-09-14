# HospitalManagementWebApp

Scopul aplicatiei este ca personalul medical din spitale sa poata crea rezervari de ture si sa 
poata vizualiza istoricul turelor salvate cu usurinta, din orice browser.

Aplicatia este dezvoltata folosind sistemul de build Maven in Eclipse, are la baza notiuni de 
OOP, Servlets, JSP, MVC, MySQL, Hibernate, Joda-Time, HTML, CSS si functioneaza dupa cum urmeaza:

Dupa ce se logheaza, user-ul care are acces la rezervarea de noi ture (ex.: Asistenta sefa) poate 
face solicitari de tura (introducand id-ul asistentei, data si ora de inceput si de sfarsit a turei). 
Daca user-ul incearca sa acceseze orice pagina care nu este publica, va fi redirectionat catre pagina 
de Login. Daca user-ul nu doreste sa continue, va avea de asemenea la dispozitie optiunea de logout in
paginile prinicipale din aplicatie.

Aplicatia va verifica in primul rand daca datele introduse sunt valide (ex.: daca un angajat cu id-ul
introdus exista, daca datele de inceput si de sfarsit sunt corect introduse din punct de vedere al 
formatului etc.), iar daca aceste date nu sunt valide, user-ul va fi atentionat in legatura cu aceste 
detalii si va fi redirectionat pentru a introduce noi date. 
	
Daca datele introduse sunt valide, aplicatia va procesa solicitarea, verificand daca noua tura respecta 
reglementarile din legislatia muncii si din regulamentul de ordine interioara: perioada minima de repaus 
de la ultima tura efectuata, data si ora de inceput si de final (pentru ture de dimineata/dupamasa/noapte/
weekend), numarul maxim de asistente care pot lucra simultan in acelasi interval de timp pe acelasi tip de
tura etc.).
	
Daca tura este eligibila, va fi salvata in baza de date, iar user-ul va fi informat cu privire la noua tura
creata. Daca tura nu este eligibila, user-ul va fi informat cu privire la aceasta si se vor afisa toate 
conditiile care trebuie respectate pentru ca o tura sa fie eligibila, precum si istoricul celorlalte ture 
salvate in baza de date pana la momentul respectiv.
