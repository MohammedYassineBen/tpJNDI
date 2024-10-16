# Système de Bibliothèque JNDI

Ce projet implémente un système de gestion de bibliothèque distribué en utilisant l'Interface de Nommage et de Répertoire Java (JNDI) et l'Invocation de Méthode à Distance (RMI). Il se compose d'un serveur qui gère une collection de livres et d'un client qui peut interagir avec le serveur pour effectuer diverses opérations.

## Structure du Projet

Le projet contient les classes Java suivantes :

1. `Livre.java` : Représente un livre avec son titre et son auteur.
2. `BibliothequeInterface.java` : Définit l'interface distante pour les opérations de la bibliothèque.
3. `BibliothequeImpl.java` : Implémente l'interface `BibliothequeInterface` et gère la collection de livres.
4. `JNDIServer.java` : Configure le serveur JNDI et lie l'objet `BibliothequeImpl`.
5. `JNDIClient.java` : Fournit une interface en ligne de commande pour que les utilisateurs interagissent avec le système de bibliothèque.

## Configuration et Compilation

1. Assurez-vous d'avoir le JDK installé et que les commandes `java` et `javac` sont disponibles dans le chemin système.

2. Assurez-vous qu'aucune autre application n'utilise le port 1099, qui est le port par défaut pour le registre RMI.

3. Assurez-vous d'ajouter le fichier [`fscontext.jar`](https://mvnrepository.com/artifact/com.sun.messaging.mq/fscontext/4.6-b01) et [`providerutil.jar`](https://mvnrepository.com/artifact/com.sun.jndi/providerutil/1.2) au projet.

4. Compilez tous les fichiers Java en utilisant la commande suivante dans le répertoire du projet :

   ```
   javac *.java
   ```

## Exécution de l'Application

1. Démarrez le Serveur JNDI :
   
   ```
   java JNDIServer
   ```
   
   Vous devriez voir le message "Serveur JNDI prêt. Bibliothèque liée." indiquant que le serveur est prêt.

2. Dans une fenêtre de terminal séparée, démarrez le Client JNDI :
   
   ```
   java JNDIClient
   ```

3. Le client affichera un menu avec des options pour ajouter un livre, rechercher un livre, lister tous les livres ou quitter l'application.

## Utilisation

Via l'interface client, vous pouvez :

1. Ajouter un nouveau livre en fournissant son titre et son auteur.
2. Rechercher un livre par son titre.
3. Lister tous les livres de la bibliothèque.
4. Quitter l'application.


## Licence

Ce projet est open-source et disponible sous la licence MIT.
