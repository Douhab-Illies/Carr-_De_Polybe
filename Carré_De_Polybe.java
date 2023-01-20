class SAEpolybe_DOUHBA_SOUFLET extends Program {
final int LARGEUR = 5;  // taille du carré (5x5 dans notre cas)
//////////////////////////////////////////////////////////////////////////
// La fonction String initialiserCarre() retourne une chaine de caractères contenant le carré de Polybe (version de base, sans clé, c'est-à-dire la chaine "ABCDEFGHIJKLMNOPQRSTUVXYZ", le V et le W sont "fusionnés" en V)
String initialiserCarreSimple(){
   String alp = "ABCDEFGHIJKLMNOPQRSTUVXYZ";                   //alp contient l'alphabet avec v et w qui sont identique
    return alp;
}
//////////////////////////////////////////////////////////////////////////
// La fonction void afficherCarre(String carre) affiche le carré de Polybe carrz passé en paramètre comme illustré dans l'exemple ci-après.
// Par exemple : si le carré passé en paramètre est : "ABCDEFGHIJKLMNOPQRSTUVXYZ", la fonction devra afficher :
//  |0 1 2 3 4
// ------------
// 0|A B C D E
// 1|F G H I J
// 2|K L M N O
// 3|P Q R S T
// 4|U V X Y Z
// NB : On considère dans cette fonction que le carré passé en paramètre est valide (càd constitué de 25 lettres distinctes en majuscule, le W se substituant en V)
void afficherCarre(String carre){
    println ("| 0  1  2  3  4 ");                                //affiche la remiere ligne
    for (int i = 0; i < 25 ; i = i + 5){                         //boucle for qui permet d'afficher tous les caracteres de initialiserCarreSimple()
        print(i/5);                                              //affiche les nombre en début de ligne
        for ( int b = 0; b < LARGEUR; b = b + 1){                //boucle for qui permet d'afficher les caracters initialiserCarreSimple() avec une séparation pour chaque ligne
            print(" ");                                          //séparateur
            print(charAt(carre, b + i));      //affiche le caractere
            print(" ");                                          //séparateur
        }
        println();                                               //retour a la ligne
    }

}
//////////////////////////////////////////////////////////////////////////
// La fonction String coderLettre (String carre, char lettre) retourne une chaîne de 2 caractères (2 entiers entre 0 inclus et LARGEUR exclus) contenant l'encodage du caractère lettre passé en paramètre en considérant le carré de Polybe carre également passé en paramètre.
// Par exemple :
// si on considère le carré de Polybe sans clé (càd le carré ABCDE représenté par la chaine "ABCDEFGHIJKLMNOPQRSTUVXYZ") :
//                                                           FGHIJ
//                                                           KLMNO               
//                                                           PQRST
//                                                           UVWYZ
//      'A' est codé "00"
//      'B' est codé "01"
//      'F' est codé "10"
//      'V' est codé "41"
//      'W' est codé "41"
//      'Z' est codé "44"
//      'P' est codé "30"
// si on considère le carré de Polybe donné par la chaine "AZERTYUIOPQSDFGHJKLMXCVBN" :
//      'A' est codé "00"
//      'B' est codé "43"
//      'Z' est codé "01"
// NB : On considère dans cette fonction que le carré passé en paramètre est valide (càd constitué de 25 lettres distinctes en majuscule, le W se substituant en V)
// Indication : pensez à la division entière et au modulo
String coderLettre(String carre, char lettre){
    int q = 0;                                                                   //initialise la variable qotient                           
    int r = 0;                                                                   //initialise la varible reste
    char z;                                                                  //initialise la variable z qui est un char
    String resultat = "";                                                    //initialise la variable resultat qui est un String
    for (int i = 0; i< length(initialiserCarreSimple()); i = i + 1){         //boucle for qui va parcourir initialiserCarreSimple() pour trouver le caractere
            z = charAt(initialiserCarreSimple(),i);                          //z est le carater de initialiserCarreSimple() dépendant de la valeur de i dans la boucle
            if (z == lettre){                                                //quand z et lettre seron identique alors :
                 //print(lettre + " est codé  ");
                 q = i / LARGEUR;                                            // q sera égale au qutient de la division euclidienne de i / 5
                 r = i % LARGEUR;                                            // r sera égale au reste de la division euclidienne de i / 5                                                 //resour a la ligne
             }
             resultat = "" +  q + r;                //met le caracter, le quotient ainsi que le reste dans la variable resultat
     }
    return resultat;                                                         //retorne resultat
}
//////////////////////////////////////////////////////////////////////////
// La fonction String coderMessage (String carre, String message) retourne une chaîne de caractères contenant l'encodage de la chaîne de caractères message passé en paramètre avec le carré de Polybe carre donné en paramètre.
// Chaque paire d'entiers (compris entre 0 et 4) correspondant à chaque lettre sera séparée de la suivante par un espace.
// Pensez à utiliser la fonction coderLettre.
// Par exemple, si le carré considéré est celui sans clé ("ABCDEFGHIJKLMNOPQRSTUVXYZ") et le message à coder est "BONJOUR" alors le résultat attendu est "01 24 23 14 24 40 32 "
// NB : On considère dans cette fonction que le carré passé en paramètre est valide (càd constitué de 25 lettres distinctes en majuscule, le W se substituant en V)
// NB : On considère dans cette fonction que le message passé en paramètre est valide (càd constitué uniquement des 26 lettres de l'alphabet en majuscule)
String coderMessage(String carre, String message){                   
       int q  = 0;                                                         //initialise la variable qotient
       int r = 0;                                                          //initialise la variable reste
       char z;                                                             //initialise la variable z qui est un char
       String messageCode = "";                                            //initialise la variable messageCode
       String resultat = "";                                               //initialise la variable résultat
       for (int a  = 0; a<length (message) ; a = a + 1){                   //premiere boucle qui va prendre chaque caractere du message
               for (int i = 0; i<length(carre); i = i + 1){                // seconde boucle qui va prendre chauqe caractere du carre
                   z = charAt(carre,i);                                    // z est le caractere de i de carre
                   if (z == charAt(message,a)){                            //si le caracter de carre en position i est egal au caractere du message en position a alors
                       q = i / LARGEUR;                                    //q sera égale au quotient de i diviser par la largeur soit 5
                       r = i % LARGEUR;                                    //r sera égale au reste de i diviser par la largeur soit 5
                   }  
                   resultat = "" + q + r + " ";                            //resultat est la conquatenation de q r et un espace
               }
           messageCode = messageCode + resultat;                           //messageCode est la succesion des lettre code qui forme un message code
       }
       return messageCode;                                                 // retourne le message Code
      
   }
//////////////////////////////////////////////////////////////////////////
// La fonction String decoderMessage (String carre, String messageCode) retourne une chaîne de caractères contenant le décodage de la chaîne de caractère messageCode avec le carré de Polybe carre donné en paramètre.
// Par exemple, si carre = "ABCDEFGHIJKLMNOPQRSTUVXYZ" et messageCode = "01 24 23 14 24 40 32 " alors le résultat attendu est "BONJOUR"
// NB : On considère dans cette fonction que le carré passé en paramètre est valide (càd constitué de 25 lettres distinctes en majuscule, le W se substituant en V)
// NB : On considère dans cette fonction que le message codé passé en paramètre est valide (càd constitué de paires d'entiers compris entre 0 et LARGEUR-1 inclus et séparées par un espace)
   char DeCoderLettre(String carre, String valeur){
    int valtotoal;                                                           //initilise valtotal qui est un int
    char caradelalph;                                                        //initilise caradelalph qui est un char
    char cara1 = charAt(valeur,0);                                           //initilise cara1 qui est le premiere caractere de valeur
    char cara2 = charAt(valeur,1);                                           //initilise cara2 qui est le deuxieme caractere de valeur
    int valeur1 = cara1 - '0';                                               //valeur1 soustrait le cara1 au caracter 0 de la table ascii ce qui permet de convertir le cara1 en int
    int valeur2 = cara2 - '0';                                               //valeur2 soustrait le cara2 au caracter 0 de la table ascii ce qui permet de convertir le cara2 en int
    valtotoal = valeur1 * 5 + valeur2;                                       //valtotal est la valeur1 mutilplier par 5 et addition valeur2 ce qui permet d'avoir le message decode
       caradelalph = charAt(carre,valtotoal);                                //caradelalph utilise le valtotal pour retrouver le caracter decode
      
       return caradelalph;
       }
 
       String decoderMessage(String carre, String messageCode){
       String message="";                                                       //initilise la variable message qui est un String
       int nbrcde = length(messageCode);                                        //initilise la variable nbrcde qui le nombre de caracter de messageCode
       for (int i = 0; i < nbrcde; i = i + 3 ){                                 //boucle for pour decoder tous les paire de caracter
      
           message=message+DeCoderLettre(carre,substring(messageCode,i,i+2));   //converti tous les paire de caractere code et retrouve les lettre utilise decode
       }
    return message;
   }
//////////////////////////////////////////////////////////////////////////
// La fonction boolean estPresent(String mot, char lettre) retourne True si le caractère lettre est dans mot, faux sinon.
// Par exemple :
//      si mot = "BONJOUR" et lettre = 'B' alors le résultat de la fonction est True
//      si mot = "BONJOUR" et lettre = 'R' alors le résultat de la fonction est True
//      si mot = "BONJOUR" et lettre = 'M' alors le résultat de la fonction est False
boolean estPresent(String mot, char c){
 boolean A = false;                                     //initialisation de boolean "A" à false     
    for(int i = 0; i < length(mot); i = i + 1)          //pour int "i" strictement inférieur au nombre de caractères dans la variable String "mot", faire i + 1
    {
        if(charAt(mot,i) == c)                          //pour chaque caractère avec comme indice "i" et qui est contenu dans "mot", vérifier si le caractère est égal à la variable char "lettre"
        {
            A = true;                                   //si la condition est remplie, mettre "A" à true
        }
    }
    return A;
}
 //////////////////////////////////////////////////////////////////////////
 // La fonction String initialiserCarreAvecCle(String cle) retourne une chaine de caractères contenant le carré de Polybe amélioré en considérant la clé passée en paramètre.
// Pensez à utiliser la fonction estPresent
// Par exemple, si cle = "BONJOUR" alors le résultat attendu est : "BONJURACDEFGHIKLMPQSTVXYZ"
// Par exemple, si cle = "BUTINFORMATIQUE" alors le résultat attendu est : "BUTINFORMAQECDGHJKLPSVXYZ"
// NB : On considère dans cette fonction que la clé passée en paramètre est valide (càd constituée uniquement de lettres de l'alphabet en majuscule, le W se substituera en V)
 String initialiserCarreAvecCle(String cle){
     String carre = cle  + initialiserCarreSimple();               //initialise carre avec la nouvelle cle + la cle de base
     String nouveauCarre = ""+charAt(cle,0);                       //initialise nouveauCarre avec le premier caractere
      boolean dansNouveauCarre = false;                            //initialise dansNouveauCarre en boolean a false
     for (int i = 0; i<length(carre); i = i + 1){                  //premier boucle for qui prend tous les caractere de carre
          for(int a = 0; a<length(nouveauCarre); a= a +1  ){       //deuxieme boucle for ajoute les dans nouveauCarre les caractere de carre
              if(charAt(carre,i) == charAt(nouveauCarre,a)){       //si le caractere est deja présent alors mettre dansNouveauCarre a true
                  dansNouveauCarre = true;
              }
          }
          if(dansNouveauCarre == false){                           //si le nouveauCarre est a false alors ajouter le caracter de carre en position i dans
              nouveauCarre = nouveauCarre + charAt(carre,i);
          }
          else{
              dansNouveauCarre = false;                            //sinon simplement remettre dansNouveauCarre a false
          }
     }
     return nouveauCarre;                                          //retourne nouveauCarre
 }
 //////////////////////////////////////////////////////////////////////////
// LES FONCTIONS QUI SUIVENT SONT DES FONCTIONS DE VERIFICATION DE SAISIE
//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
// La fonction boolean estLettreMajuscule(char c) vérifie le caractère passé en paramètre est une lettre de l'alphabet en majuscule
// Par exemple :
//  si c='b', la fonction retourne false
//  si c='B', la fonction retourne true
   boolean estLettreMajuscule(char c){
    boolean A = false;                                  //initialise A à false
    if(c >= 'A' && c <= 'Z')                  //condition : si le caractère dans lettre est entre A compris et Z compris
    {
        A = true;                                       //alors : mettre A à true
    }
    return A;                                           //retourner A.
  }
//////////////////////////////////////////////////////////////////////////
// La fonction estCleValide vérifie que la clé passée en paramètre est valide (càd constituée uniquement de lettres de l'alphabet en majuscule)
// Par exemple :
//  si cle="BUTINFORMATIQUE", la fonction retourne true
//  si cle="BUTINF ORMATIQUE", la fonction retourne false
//  si cle="BUTINFORMATIQUE!", la fonction retourne false
//  si cle="ButInformatique", la fonction retourne false
  boolean estCleValide(String cle){
    boolean A = true;                                           //initialise A à true
    int i = 0;                                                  //initialise i à 0
    char caraA = charAt(cle,0);                                 //initialise le Char de cara avec l'indice 0 qui changera apres
    int longeur = length(cle);                                  //longeur de la chaine
    while(A && i<longeur){                                      //tant que A est valdide est que la chaine i est inferieur a la cahine
          caraA = charAt(cle,i);                                //on extrait un caractere de cle a chaque tours de boucle
          A = estLettreMajuscule(caraA);                        //mettre dans A la reponse au programe estLettreMajuscule
      i = i + 1;                                                //rajoute un tours de boucle
    }
  
    return A;                                                   //retourne A dans estCleValide
  }
//////////////////////////////////////////////////////////////////////////
// La fonction estChiffreOK vérifie que le chiffre passé en paramètre est valide (càd est un entier compris entre 0 et LARGEUR-1)
// Par exemple :
//  si messageCode=""01 24 23 14 24 40 32 ", la fonction retourne true
//  si messageCode=""01 24 23 14 24 40 32", la fonction retourne false
//  si messageCode=""01 24 23 14 24 40 3", la fonction retourne false
//  si messageCode=""01 25 23 14 24 40 32 ", la fonction retourne false
//  si messageCode=""01242314244032", la fonction retourne false
  boolean estChiffreOK(int chiffre){
      boolean ok = false;                                      //initilise booloan ok a false
      if (chiffre>= 0 && chiffre <= LARGEUR-1 ){               //si le le chiffre est compris entre o et LARGEUR-1 alors
          ok = true;                                           //ok est lis a true
      }
      return ok;                                               //retourne ok
  }
//////////////////////////////////////////////////////////////////////////
// La fonction estMessageCodeValide vérifie que le message codé passé en paramètre est valide (càd constituée uniquement de paires d'entiers compris entre 0 et LARGEUR-1 et que chaque paire est séparée de la suivante par un espace, et un espace final)
// Par exemple :
//  si messageCode=""01 24 23 14 24 40 32 ", la fonction retourne true
//  si messageCode=""01 24 23 14 24 40 32", la fonction retourne false
//  si messageCode=""01 24 23 14 24 40 3", la fonction retourne false
//  si messageCode=""01 25 23 14 24 40 32 ", la fonction retourne false
//  si messageCode=""01242314244032", la fonction retourne false
boolean estMessageCodeValide(String messageCode){
  char charchiffre = ' ';
  int intchiffre = 0;
  boolean verif = true;
  int indice = 0;
  if((length(messageCode) % 3) == 0){
      while(indice < length(messageCode) && verif){
          charchiffre = charAt(messageCode, indice);
          if(charchiffre >= '0' && charchiffre <= '9'){
              intchiffre = ((int)charchiffre) - 48;
              estChiffreOK(intchiffre);
              if(estChiffreOK(intchiffre) == true){
                  indice = indice + 1;
              }else{
                  verif = false;
              }
          }else if(charchiffre == ' '){
              indice = indice + 1;
          }else{
              verif = false;
          }
      }
  }else{
      verif = false;
  }
  return verif;
  }
//////////////////////////////////////////////////////////////////////////
// La fonction estMessageValide vérifie que le message passé en paramètre est valide (càd constitué uniquement de lettres de l'alphabet en majuscule)
  boolean estMessageValide(String message){
      boolean MessageValide = false;                           //initialise MessageValide en boolean a false
      int i = 0;                                               //initilise le compteur i a 0
      int longeur = length(message);                           //initiliase longeur qui la longeur de la chaine de caractere de message
      while (estCleValide(message) && i < longeur){            //tant que estCleValide pour message et que i est inferieur a longeur
          MessageValide = true;                                //met MessageValide a true
          i = i + 1;                                           // ajoute 1 a i a chauqe tours de boucle
      }
    return MessageValide;                                      //retourne MessageValide
  }
//////////////////////////////////////////////////////////////////////////
// PROGRAMME PRINCIPAL
//////////////////////////////////////////////////////////////////////////
// Ecrire un programme principal qui :
// 1. affiche un message d'introduction à l'utilisateur
// 2. affiche un message à l'utilisateur demandant s'il veut utiliser une clé ?
// 3. lit la réponse de l'utilisateur
// 4. si l'utilisateur a répondu oui, demande et lit la clé souhaitée
// 5. affiche le carré de Polybe (générique (càd sans clé) ou avec clé selon la réponse précédente de l'utilisateur)
// 6. tant que la réponse n'est pas 0, affiche un menu et demande à l'utilisateur de saisir un entier (0 ou 1 ou 2 ou 3) pour :
//              0. QUITTER
//              1. CODER UN MESSAGE
//              2. DECODER UN MESSAGE
//              3. MODIFIER LE MODE AVEC/SANS CLE
//        puis agit en conséquence.
// NB : si et tant qu'une saisie de l'utilisateur n'est pas correcte, il faut la redemander (que ce soit pour la clé, le message à coder, le message à décoder ou le choix dans le menu)
  void algorithm(){
      String message;
      String messageCode = "";
      String carre = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
      int reponse;
      String questioncle = "";
      String cle = "";
      boolean estValide = false;
     
 
       println(" _____     _     _       ");
       println("|  _  |___| |_ _| |_ ___ ");
       println("|   __| . | | | | . | -_|");
       println("|__|  |___|_|_  |___|___|");
       println("            |___|        ");
 
      println("Voulez-vous utiliser une cle (oui/non)");
      questioncle = readString();
      if (equals(questioncle,"oui")){
       println("Veuillez saisir votre cle en majuscule");
       cle = readString();
       carre = initialiserCarreAvecCle(cle);
       println("carre : ");
       afficherCarre(carre);
      }
      else if(equals(questioncle,"non")) {
       carre = initialiserCarreSimple();
       println("carre : ");
       afficherCarre(carre);
       
      }
     
    
      do{
           println();
          println("0. QUITTER");
          println("1. CODER UN MESSAGE");
          println("2. DECODER UN MESSAGE");
          println("3. MODIFIER LE MODE AVEC/SANS CLE");
          println("4. AFFICHER LE CARRE");
          reponse = readInt();
          if(reponse == 1){
          
              message = readString();
              if(estMessageValide(message)){
                  messageCode = coderMessage(carre, message);
                  println(messageCode);
              }
              else{
                  println("ERREUR MESSAGE NON VALIDE !");
              }
           }else if(reponse == 2){
              
                  println ("ecrire un mesage code tels que : XX XX XX ...");
                  messageCode = readString();
                  if (estMessageCodeValide(messageCode)){
                   println(decoderMessage(carre, messageCode));
                  }else{
                   println("ERREUR MESSAGE NON VALIDE !");
                  }
             
           }else if (reponse == 3){
          
              println("NE PAS ECRIRE 2 FOIS LE MEME CARACTERE !");
              cle = readString();
              carre = initialiserCarreAvecCle(cle);
              print("carre : ");
              println(carre);
           }
           else if (reponse == 4){
            afficherCarre(carre);
            println(carre);
           }
         
      }while (reponse != 0);
  }
}
