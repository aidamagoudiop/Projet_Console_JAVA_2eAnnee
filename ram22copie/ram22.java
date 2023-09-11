

import java.util.Scanner;
import java.sql.*;
import java.lang.Exception;
    public class ram22 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            // informations de connexion à la base de données
//            String url = "jdbc:mysql://localhost/RAM";
            String url = "jdbc:mysql://localhost/RAM";
            String user = "root";
            String password = "";
            // chargement du pilote JDBC pour MySQL
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }

            System.out.println(" ");
            System.out.println(" ");
            System.out.println("|***************************************************************************************|");

            System.out.println(" ");

            System.out.println("========================================================================================");
            System.out.println("====================Bienvenu(e) chez *AMOUD* COMPAGNIE AERIENNE :=======================");
            System.out.println("========================================================================================");

            System.out.println(" ");

            System.out.println("|***************************************************************************************|");
            System.out.println(" ");
            System.out.println("Voici les options qui s'offrent a vous:");
            System.out.println(" ");


            int choix = 0;
            while (choix != 21) {

//                System.out.println("~~~~~~~~~~~~ 1. Créer un client ~~~~~~~~~~~");
//                System.out.println("~~~~~~~~~~~~ 1. Créer un client ~~~~~~~~~~~");
//                System.out.println("~~~~~~~~~~~~ 1. Créer un client ~~~~~~~~~~~");
//                System.out.println("~~~~~~~~~~~~ 1. Créer un client ~~~~~~~~~~~");
//                System.out.println("~~~~~~~~~~~~ 1. Créer un client ~~~~~~~~~~~");
//                System.out.println("~~~~~~~~~~~~ 1. Créer un client ~~~~~~~~~~~");
//                System.out.println("~~~~~~~~~~~~ 1. Créer un client ~~~~~~~~~~~");
//                System.out.println("~~~~~~~~~~~~ 1. Créer un client ~~~~~~~~~~~");
//                System.out.println("~~~~~~~~~~~~ 1. Créer un client ~~~~~~~~~~~");
//                System.out.println("~~~~~~~~~~~~ 1. Créer un client ~~~~~~~~~~~");
//                System.out.println("~~~~~~~~~~~~ 1. Créer un client ~~~~~~~~~~~");




                System.out.println("\t\t\t\t\t 1. Créer un client");
                System.out.println("\t\t\t\t\t 2. Créer un reservation");
                System.out.println("\t\t\t\t\t 3. Créer un gestionnaire");
                System.out.println("\t\t\t\t\t 4. Créer un vol");
                System.out.println("\t\t\t\t\t 5. Créer un Avion");
                System.out.println("\t\t\t\t\t 6. creer un Administrateur");
                System.out.println("\t\t\t\t\t 7. Créer un Compte");

                System.out.println("\t\t\t\t\t 8. Supprimer un client");
                System.out.println("\t\t\t\t\t 9. Supprimer un reservation");
                System.out.println("\t\t\t\t\t 10. Supprimer un gestionnaire");
                System.out.println("\t\t\t\t\t 11. Supprimer un vol");
                System.out.println("\t\t\t\t\t 12. Supprimer un Avion");
                System.out.println("\t\t\t\t\t 13. Supprimer un Administrateur");
                System.out.println("\t\t\t\t\t 14. Supprimer un Administrateur");

                System.out.println("\t\t\t\t\t 15. Afficher les clients");
                System.out.println("\t\t\t\t\t 16. Afficher les reservations");
                System.out.println("\t\t\t\t\t 17. Afficher les gestionnaires");
                System.out.println("\t\t\t\t\t 18. Afficher les vols");
                System.out.println("\t\t\t\t\t 19. Afficher les Avions");
                System.out.println("\t\t\t\t\t 20. Afficher Administrateur");
                System.out.println("\t\t\t\t\t 21. Afficher les Comptes");

                System.out.println("\t\t\t\t\t 0. Exit");

                System.out.println("|***********************************************************************************|");
                System.out.println(" ");
                System.out.println("Veuillez saisir le chiffre ou nombre correspondant a votre choix:");
                System.out.println(" ");

                choix = scanner.nextInt();
                scanner.nextLine(); // consommer le retour à la ligne

                switch (choix) {

                    // AJOUTS

                    case 1:
                        // insérer le code pour créer un Client ici
                        try {
                            // connexion à la base de données
                            Connection connection = DriverManager.getConnection(url, user, password);

                            // insertion dans la table championnat_echecs
                            PreparedStatement insertClient = connection
                                    .prepareStatement("INSERT INTO Client(telephone, nom, prenom) VALUES (?, ?, ?)");
                            System.out.println("insertion dans la table Client");
                            System.out.print("Entrez le telephone : ");
                            int telephoneClient = scanner.nextInt();
                            scanner.nextLine();
                            insertClient.setInt(1, telephoneClient);
                            System.out.print("Entrez le nom du client: ");
                            String nomClient = scanner.nextLine();
                            insertClient.setString(2, nomClient);
                            System.out.print("Entrez le prenom du client : ");
                            String prenomClient = scanner.nextLine();
                            insertClient.setString(3, prenomClient);
                            insertClient.executeUpdate();
                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        break;
                    case 2:
                        // insérer le code pour créer une reservation ici
                        try {
                            // connexion à la base de données
                            Connection connection = DriverManager.getConnection(url, user, password);
                            PreparedStatement insertReservation = connection.prepareStatement(
                                    "INSERT INTO Reservation(numero, dateReservation, etat, paiement) VALUES (?, ?, ?, ?)");
                            System.out.println("insertion dans la table reservation");

                            System.out.print("Entrez le numéro de la table reservation :");
                            String numeroReservaion = scanner.nextLine();
                            // consommer le retour à la ligne//// insertJoueur.setInt(1, numeroJoueur);
                            insertReservation.setString(1, numeroReservaion);

                            System.out.print("Entrez la date de reservation (au format YYYY-MM-DD): ");
                            String dateReservation = scanner.nextLine();
                            insertReservation.setDate(2, Date.valueOf(dateReservation));

                            System.out.print("Entrez l'etat de la reservation  : ");
                            String etatReservation = scanner.nextLine();
                            insertReservation.setString(3, etatReservation);

                            System.out.print("Entrez le paiement de la reservation:  ");
                            String paiementReservation = scanner.nextLine();
                            insertReservation.setString(4, paiementReservation);

                            insertReservation.executeUpdate();

                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        break;
                    case 3: // gestionnaire
                        // insérer le code pour créer une partie ici

                        try {
                            // connexion à la base de données
                            Connection connection = DriverManager.getConnection(url, user, password);
                            PreparedStatement insertGestionnaire = connection
                                    .prepareStatement("INSERT INTO Gestionnaire(telephone, nom, prenom) VALUES (?, ?, ?)");
                            System.out.println("insertion dans la table Gestionnaire");

                            System.out.print("Entrez le telephone du Gestionnaire : ");
                            int telephoneGestionnaire = scanner.nextInt();
                            scanner.nextLine(); // consommer le retour à la ligne
                            insertGestionnaire.setInt(1, telephoneGestionnaire);

                            System.out.print("Entrez le nom du Gestionnaire : ");
                            String nomGestionnaire = scanner.nextLine();
                            insertGestionnaire.setString(2, nomGestionnaire);

                            System.out.print("Entrez le prenom du Gestionnaire : ");
                            String prenomGestionnaire = scanner.nextLine();
                            insertGestionnaire.setString(3, prenomGestionnaire);

                            insertGestionnaire.executeUpdate();

                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 4: // vol
                        try {
                            // connexion à la base de données
                            Connection connection = DriverManager.getConnection(url, user, password);
                            PreparedStatement insertVol = connection.prepareStatement(
                                    "INSERT INTO Vol(numero, dateDepart, dateArrive, heureDepart ,heureArrive ,etat) VALUES (?, ?, ?, ?, ?, ?)");
                            System.out.println("insertion dans la table Vol");

                            System.out.print("Entrez le numéro du vol:");
                            String numeroVol = scanner.nextLine();
                            // consommer le retour à la ligne//// insertJoueur.setInt(1, numeroJoueur);
                            insertVol.setString(1, numeroVol);

                            System.out.print("Entrez la date de depart du vol (au format YYYY-MM-DD): ");
                            String dateDepartVol = scanner.nextLine();
                            insertVol.setDate(2, Date.valueOf(dateDepartVol));

                            System.out.print("Entrez la date d'arrive du vol (au format YYYY-MM-DD): ");
                            String dateArriveVol = scanner.nextLine();
                            insertVol.setDate(3, Date.valueOf(dateArriveVol));

                            System.out.print("Entrez l'heure de depart du vol : ");
                            int heureDepartVol = scanner.nextInt();
                            scanner.nextLine(); // consommer le retour à la ligne
                            insertVol.setInt(4, heureDepartVol);

                            System.out.print("Entrez l'heure d'arrivee du vol  : ");
                            int heureArriveVol = scanner.nextInt();
                            scanner.nextLine(); // consommer le retour à la ligne
                            insertVol.setInt(5, heureArriveVol);

                            System.out.print("Entrez l'etat du vol : ");
                            String etatVol = scanner.nextLine();
                            insertVol.setString(6, etatVol);

                            insertVol.executeUpdate();

                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        break;

                    case 5: // avion
                        try {
                            // connexion à la base de données
                            Connection connection = DriverManager.getConnection(url, user, password);

                            // insertion dans la table Avion
                            PreparedStatement insertAvion = connection
                                    .prepareStatement("INSERT INTO Avion(identifiant, type) VALUES (?, ?)");
                            System.out.println("insertion dans la table Avion");

                            System.out.print("Entrez l'identifiant de l' Avion: ");
                            String identifiantAvion = scanner.nextLine();
                            insertAvion.setString(1, identifiantAvion);

                            System.out.print("Entrez le type de l'Avion: ");
                            String typeAvion = scanner.nextLine();
                            insertAvion.setString(2, typeAvion);

                            insertAvion.executeUpdate();
                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 6: // administrateur
                        try {

                            // connexion à la base de données
                            Connection connection = DriverManager.getConnection(url, user, password);

                            // insertion dans la table Administrateur
                            PreparedStatement insertAdministrateur = connection.prepareStatement(
                                    "INSERT INTO Administrateur(telephone, nom, prenom) VALUES (?, ?, ?)");
                            System.out.println("insertion dans la table Administrateur");

                            System.out.print("Entrez le telephone : ");
                            int telephoneAdministrateur = scanner.nextInt();
                            scanner.nextLine();
                            insertAdministrateur.setInt(1, telephoneAdministrateur);

                            System.out.print("Entrez le nom de l'Administrateur: ");
                            String nomAdministrateur = scanner.nextLine();
                            insertAdministrateur.setString(2, nomAdministrateur);

                            System.out.print("Entrez le prenom de l'Administrateur: ");
                            String prenomAdministrateur = scanner.nextLine();
                            insertAdministrateur.setString(3, prenomAdministrateur);

                            insertAdministrateur.executeUpdate();
                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        break;

                    case 7: // compte
                        try {
                            Connection connection = DriverManager.getConnection(url, user, password);
                            PreparedStatement insertCompte = connection.prepareStatement(
                                    "INSERT INTO Compte(code, proprietaire, nombreComptes) VALUES (?, ?, ?)");
                            System.out.println("insertion dans la table Compte");

                            System.out.print("Entrez le code du Compte : ");
                            int codeCompte = scanner.nextInt();
                            scanner.nextLine(); // consommer le retour à la ligne
                            insertCompte.setInt(1, codeCompte);

                            System.out.print("Entrez le proprietaire du compte : ");
                            String proprietaireCompte = scanner.nextLine();
                            insertCompte.setString(2, proprietaireCompte);

                            System.out.print("Entrez le nombre de comptes : ");
                            int nombreComptes = scanner.nextInt();
                            insertCompte.setInt(3, nombreComptes);

                            insertCompte.executeUpdate();

                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    // SUPPRESSIONS

                    case 8: // client
                        try {
                            Connection connection = DriverManager.getConnection(url, user, password);

                            // suppression dans la table championnat_echecs
                            PreparedStatement deleteClient = connection
                                    .prepareStatement("DELETE FROM Client WHERE telephone = ?");
                            System.out.println("suppression dans la table Client");

                            System.out.print("Entrez le telephone du Client à supprimer : ");
                            int telephoneClient = scanner.nextInt();
                            scanner.nextLine();
                            deleteClient.setInt(1, telephoneClient);
                            int rowsAffected = deleteClient.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("Le client a été supprimé avec succès.");
                            } else {
                                System.out.println("Aucun client n'a été supprimé.");
                            }

                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 9: // reservation
                        try {
                            Connection connection = DriverManager.getConnection(url, user, password);

                            // suppression dans la table championnat_echecs
                            PreparedStatement deleteReservation = connection
                                    .prepareStatement("DELETE FROM Reservation WHERE numero = ?");
                            System.out.println("suppression dans la table Reservation");

                            System.out.print("Entrez le numero de la Reservation à supprimer : ");
                            String numeroReservation = scanner.nextLine();
                            deleteReservation.setString(1, numeroReservation);

                            int rowsAffected = deleteReservation.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("La Reservation a été supprimée avec succès.");
                            } else {
                                System.out.println("Aucune Reservation n'a été supprimée.");
                            }

                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 10: // gestionnaire
                        try {
                            Connection connection = DriverManager.getConnection(url, user, password);

                            // suppression dans la table gestionnaire
                            PreparedStatement deleteGestionnaire = connection
                                    .prepareStatement("DELETE FROM Gestionnaire WHERE telephone = ?");
                            System.out.println("suppression dans la table Gestionnaire");

                            System.out.print("Entrez le telephone du Gestionnaire à supprimer : ");
                            int telephoneGestionnaire = scanner.nextInt();
                            deleteGestionnaire.setInt(1, telephoneGestionnaire);

                            int rowsAffected = deleteGestionnaire.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("Le Gestionnaire a été supprimé avec succès.");
                            } else {
                                System.out.println("Aucun Gestionnaire n'a été supprimée.");
                            }

                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 11: // vol
                        try {
                            Connection connection = DriverManager.getConnection(url, user, password);

                            // suppression dans la table Vol
                            PreparedStatement deleteVol = connection.prepareStatement("DELETE FROM Vol WHERE numero = ?");
                            System.out.println("suppression dans la table Vol");

                            System.out.print("Entrez le numero du Vol à supprimer : ");
                            String numeroVol = scanner.nextLine();
                            deleteVol.setString(1, numeroVol);

                            int rowsAffected = deleteVol.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("Le Vol a été supprimé avec succès.");
                            } else {
                                System.out.println("Aucun Vol n'a été supprimé.");
                            }

                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 12: // avion
                        try {
                            Connection connection = DriverManager.getConnection(url, user, password);

                            // suppression dans la table avion
                            PreparedStatement deleteAvion = connection
                                    .prepareStatement("DELETE FROM Avion WHERE identifiant = ?");
                            System.out.println("suppression dans la table Avion");

                            System.out.print("Entrez le'identifiant de l'Avion à supprimer : ");
                            String identifiantAvion = scanner.nextLine();
                            deleteAvion.setString(1, identifiantAvion);

                            int rowsAffected = deleteAvion.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("L'Avion a été supprimé avec succès.");
                            } else {
                                System.out.println("Aucun Avion n'a été supprimé.");
                            }

                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 13: // administrateur
                        try {
                            Connection connection = DriverManager.getConnection(url, user, password);

                            // suppression dans la table Administrateur
                            PreparedStatement deleteAdministrateur = connection
                                    .prepareStatement("DELETE FROM Administrateur WHERE telephone = ?");
                            System.out.println("suppression dans la table Administrateur");

                            System.out.print("Entrez le telephone due l'Administrateur à supprimer : ");
                            int telephoneAdministrateur = scanner.nextInt();
                            deleteAdministrateur.setInt(1, telephoneAdministrateur);

                            int rowsAffected = deleteAdministrateur.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("L'Administrateur a été supprimé avec succès.");
                            } else {
                                System.out.println("Aucun Administrateur n'a été supprimée.");
                            }

                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 14: // compte
                        try {
                            Connection connection = DriverManager.getConnection(url, user, password);

                            // suppression dans la table compte
                            PreparedStatement deleteCompte = connection
                                    .prepareStatement("DELETE FROM Compte WHERE code = ?");
                            System.out.println("suppression dans la table Compte");

                            System.out.print("Entrez le code du Compte à supprimer : ");
                            int codeCompte = scanner.nextInt();
                            deleteCompte.setInt(1, codeCompte);

                            int rowsAffected = deleteCompte.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("Le Compte a été supprimé avec succès.");
                            } else {
                                System.out.println("Aucun Compte n'a été supprimé.");
                            }

                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    // AFFICHAGES

                    case 15: // CLIENT
                        try {
                            // connexion à la base de données
                            Connection connection = DriverManager.getConnection(url, user, password);
                            // requête SELECT pour afficher toutes les valeurs de la table client
                            String selectClient = "SELECT * FROM Client";
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery(selectClient);
                            System.out.println("Table client :");
                            System.out.println();
                            while (resultSet.next()) {
                                System.out.println(
                                        "+---------------+---------------+-------------------+-------------------+------------------------+");
                                System.out.println("telephone_du_client| nom_du_client\t| prenom_du_client|");
                                System.out.println(
                                        "+---------------+---------------+-------------------+-------------------+------------------------+");
                                System.out.println(
                                        "\t\t" + resultSet.getInt("telephone") + "\t\t|\t\t\t" + resultSet.getString("nom")
                                                + "|\t\t" + resultSet.getString("prenom") + "            |");
                                System.out.println(
                                        "+---------------+---------------+-------------------+-------------------+------------------------+");

                            }
                            System.out.println();
                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 16: // reservation
                        try {
                            // connexion à la base de données
                            Connection connection = DriverManager.getConnection(url, user, password);
                            // requête SELECT pour afficher toutes les valeurs de la table reservation
                            String selectReservation = "SELECT * FROM Reservation";
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery(selectReservation);
                            System.out.println("Table Reservation :");
                            System.out.println();
                            while (resultSet.next()) {
                                System.out.println(
                                        "+---------------+---------------+-------------------+-------------------+------------------------+");
                                System.out.println(
                                        "numero_reservation| date_de_reservation\t| etat_reservation\t| paiement_reservation  |");
                                System.out.println(
                                        "+---------------+---------------+-------------------+-------------------+------------------------+");
                                System.out.println("\t\t" + resultSet.getString("numero") + "\t\t|\t\t\t"
                                        + resultSet.getDate("dateReservation") + "|\t\t" + resultSet.getString("etat")
                                        + "|\t\t" + resultSet.getString("paiement") + "           |");
                                System.out.println(
                                        "+---------------+---------------+-------------------+-------------------+------------------------+");

                            }
                            System.out.println();
                            // fermeture de la connexion à la base de données
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    // case 9:
                    // try {
                    // // connexion à la base de données
                    // Connection connection = DriverManager.getConnection(url, user, password);
                    // // requête SELECT pour afficher toutes les valeurs de la table
                    // championnat_echecs
                    // String selectPartie = "SELECT * FROM Partie";
                    // Statement statement = connection.createStatement();
                    // ResultSet resultSet = statement.executeQuery(selectPartie);
                    // System.out.println("Table Partie :");
                    // while (resultSet.next()) {
                    //// System.out.println("numero partie: "+resultSet.getInt("numero")+";" + "\t"
                    //// +"etat partie: "+ resultSet.getBoolean("est_fini")+";" + "\t"
                    //// +"id championnat: "+ resultSet.getInt("id_championnat2")+";" + "\t"
                    //// +"numero joueur blanc: "+ resultSet.getInt("joueur_blanc")+";" + "\t"
                    //// +"numero joueur noir: "+ resultSet.getInt("joueur_noir"));
                    // System.out.println("+------------+---------------+-----------------+-------------------------+----------------------+");
                    // System.out.println("numero_partie| etat_partie\t | id_championnat |
                    // numero_joueur_blanc\t | numero_joueur_noir |");
                    // System.out.println("+------------+---------------+-----------------+-------------------------+----------------------+");
                    // System.out.println("\t\t"+resultSet.getInt("numero") + "\t |\t" +
                    // resultSet.getBoolean("est_fini") + "\t |\t\t" +
                    // resultSet.getInt("id_championnat2") + "\t\t | \t\t" +
                    // resultSet.getInt("joueur_blanc") + "\t\t\t\t |\t\t\t" +
                    // resultSet.getInt("joueur_noir")+ " |");
                    // System.out.println("+------------+---------------+-----------------+-------------------------+----------------------+");
                    //
                    // }
                    // System.out.println();
                    // //fermeture de la connexion à la base de données
                    // connection.close();
                    // } catch (SQLException e) {
                    // e.printStackTrace();
                    //
                    // }
                    // break;
                    //
                    // case 10:
                    // System.out.println("Au revoir !");
                    // break;
                    // default:
                    // System.out.println("Option invalide, veuillez réessayer.");
                    // break;

                }
            }
            scanner.close();
        }
    }
