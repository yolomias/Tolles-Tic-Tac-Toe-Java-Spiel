package tictactoe_game;

import javax.swing.*;
import java.util.Random;

public class Toe_GUI {

    private JPanel Paneel;
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton c1;
    private JButton c2;
    private JButton c3;
    private JButton spielStarten;
    private JButton cpuLeicht;
    private JButton cpuSchwer;
    private boolean starter = false;
    private String[][] spielFeld;
    private int gerade;
    private boolean randomizer = false;
    private boolean gewinner = false;
    private boolean schwer = false;
    private boolean siegPruefer = false;

    //damit das Laden von Icons funktioniert
    private void loadIcon (JButton button, String path) {
        Icon icon = new ImageIcon(getClass().getResource(path));
        button.setIcon(icon);
    }

    //Setze das Spielfeld auf den Urpsrungszustand zurück
    private void neutralisiereSpielfeld ()
    {
        spielFeld = new String[][]
                {
                {"0", "0", "0"},
                {"0", "0", "0"},
                {"0", "0", "0"}
                };
        a1.setIcon(null);
        a2.setIcon(null);
        a3.setIcon(null);
        b1.setIcon(null);
        b2.setIcon(null);
        b3.setIcon(null);
        c1.setIcon(null);
        c2.setIcon(null);
        c3.setIcon(null);
        gerade = 0;
        starter = true;
        gewinner = false;
        schwer = false;
        randomizer = false;
    }

    //Wenn auf ein Spielbutton geklickt wird
    private void buttonClicked (int x, int y)
    {
        if (starter) {
            //Zahl ist Gerade, Kreuz
            if ((gerade % 2) == 0 && spielFeld[x][y].equals("0"))
            {
                ankreuzer(x, y, 'X');
                spielFeld[x][y] = "X";
                gerade += 1;
            } else if ((gerade % 2) != 0 && spielFeld[x][y].equals("0"))
            {
                ankreuzer(x, y, 'o');
                spielFeld[x][y] = "o";
                gerade += 1;
                gewinnPruefer();
                kreuzRand();
                schwereCPU();
            }
            gewinnPruefer();
        }
    }

    //Gibt eine zufällige Zahl zurück
    private int randominator (int r)
    {
        Random rand = new Random();
        return rand.nextInt(r);
    }

    //Läßt ein Kreuz oder Kreis erscheinen
    private void ankreuzer (int xx, int yy, char zz)
    {
        if (zz == 'X')
        {
            if (xx == 0 && yy == 0) loadIcon(a1, "kreuz.png");
            else if (xx == 0 && yy == 1) loadIcon(a2, "kreuz.png");
            else if (xx == 0 && yy == 2) loadIcon(a3, "kreuz.png");
            else if (xx == 1 && yy == 0) loadIcon(b1, "kreuz.png");
            else if (xx == 1 && yy == 1) loadIcon(b2, "kreuz.png");
            else if (xx == 1 && yy == 2) loadIcon(b3, "kreuz.png");
            else if (xx == 2 && yy == 0) loadIcon(c1, "kreuz.png");
            else if (xx == 2 && yy == 1) loadIcon(c2, "kreuz.png");
            else if (xx == 2 && yy == 2) loadIcon(c3, "kreuz.png");
        }
        else if (zz == 'o')
        {
            if (xx == 0 && yy == 0) loadIcon(a1, "kreis.png");
            else if (xx == 0 && yy == 1) loadIcon(a2, "kreis.png");
            else if (xx == 0 && yy == 2) loadIcon(a3, "kreis.png");
            else if (xx == 1 && yy == 0) loadIcon(b1, "kreis.png");
            else if (xx == 1 && yy == 1) loadIcon(b2, "kreis.png");
            else if (xx == 1 && yy == 2) loadIcon(b3, "kreis.png");
            else if (xx == 2 && yy == 0) loadIcon(c1, "kreis.png");
            else if (xx == 2 && yy == 1) loadIcon(c2, "kreis.png");
            else if (xx == 2 && yy == 2) loadIcon(c3, "kreis.png");
        }
    }

    //Überprüfe ob ein Spieler gewonnen hat
    private void gewinnPruefer ()
    {
            int gewinnKreuz = 0;
            int gewinnKreis = 0;

            //prüft horizontale Reihen
            for (int i = 0; i <= 2; i++) {
                gewinnKreuz = 0;
                gewinnKreis = 0;

                for (int j = 0; j <= 2; j++) {
                    if (spielFeld[i][j].equals("X")) gewinnKreuz += 1;
                    else if (spielFeld[i][j].equals("o")) gewinnKreis += 1;
                }

                if (gewinnKreuz == 3 && !gewinner) {
                    System.out.println("Kreuz gewinnt");
                    JOptionPane.showMessageDialog(null, "Spieler Kreuz hat gewonnen, toll!1!");
                    starter = false;
                    gewinner = true;
                    break;
                } else if (gewinnKreis == 3 && !gewinner) {
                    System.out.println("Kreis gewinnt");
                    JOptionPane.showMessageDialog(null, "Spieler Kreis hat gewonnen, da hat Spieler" +
                            " Kreuz wohl geschlafen!!1");
                    starter = false;
                    gewinner = true;
                    break;
                }
            }

            //prüft vertikale Reihen
            for (int i = 0; i <= 2; i++) {
                gewinnKreuz = 0;
                gewinnKreis = 0;

                for (int j = 0; j <= 2; j++) {
                    if (spielFeld[j][i].equals("X")) gewinnKreuz += 1;
                    else if (spielFeld[j][i].equals("o")) gewinnKreis += 1;
                }

                if (gewinnKreuz == 3 && !gewinner) {
                    System.out.println("Kreuz gewinnt");
                    JOptionPane.showMessageDialog(null, "Spieler Kreuz hat gewonnen, toll!1!");
                    starter = false;
                    gewinner = true;
                    break;
                } else if (gewinnKreis == 3 && !gewinner) {
                    System.out.println("Kreis gewinnt");
                    JOptionPane.showMessageDialog(null, "Spieler Kreis hat gewonnen, da hat Spieler" +
                            " Kreuz wohl geschlafen!!1");
                    starter = false;
                    gewinner = true;
                    break;
                }
            }

            //prüft diagonalen
            gewinnKreuz = 0;
            gewinnKreis = 0;
            if (spielFeld[0][0].equals("X")) gewinnKreuz += 1;
            else if (spielFeld[0][0].equals("o")) gewinnKreis += 1;
            if (spielFeld[1][1].equals("X")) gewinnKreuz += 1;
            else if (spielFeld[1][1].equals("o")) gewinnKreis += 1;
            if (spielFeld[2][2].equals("X")) gewinnKreuz += 1;
            else if (spielFeld[2][2].equals("o")) gewinnKreis += 1;

            if (gewinnKreuz == 3 && !gewinner) {
                System.out.println("Kreuz gewinnt");
                JOptionPane.showMessageDialog(null, "Spieler Kreuz hat gewonnen, toll!1!");
                starter = false;
                gewinner = true;
            } else if (gewinnKreis == 3 && !gewinner) {
                System.out.println("Kreis gewinnt");
                JOptionPane.showMessageDialog(null, "Spieler Kreis hat gewonnen, da hat Spieler" +
                        " Kreuz wohl geschlafen!!1");
                starter = false;
                gewinner = true;
            }

            gewinnKreuz = 0;
            gewinnKreis = 0;
            if (spielFeld[0][2].equals("X")) gewinnKreuz += 1;
            else if (spielFeld[0][2].equals("o")) gewinnKreis += 1;
            if (spielFeld[1][1].equals("X")) gewinnKreuz += 1;
            else if (spielFeld[1][1].equals("o")) gewinnKreis += 1;
            if (spielFeld[2][0].equals("X")) gewinnKreuz += 1;
            else if (spielFeld[2][0].equals("o")) gewinnKreis += 1;

            if (gewinnKreuz == 3 && !gewinner) {
                System.out.println("Kreuz gewinnt");
                JOptionPane.showMessageDialog(null, "Spieler Kreuz hat gewonnen, toll!1!");
                starter = false;
                gewinner = true;
            } else if (gewinnKreis == 3 && !gewinner) {
                System.out.println("Kreis gewinnt");
                JOptionPane.showMessageDialog(null, "Spieler Kreis hat gewonnen, da hat Spieler" +
                        " Kreuz wohl geschlafen!!1");
                starter = false;
                gewinner = true;
            }
        if (gerade >= 9 && !gewinner)
        {
            System.out.println("Unentschieden!!");
            JOptionPane.showMessageDialog(null, "Unentschieden, dass muss durch eine weitere" +
                    " Runde entschieden werden1!!");
        }
    }

    //Starte Spiel gegen Mitspieler
    private void starteSpiel ()
    {
        neutralisiereSpielfeld();
        randomizer = false;
    }

    //Starte Spiel gegen leichte KI
    private void starteCpuL ()
    {
        neutralisiereSpielfeld();
        randomizer = true;
        kreuzRand();
    }

    //Kreuzt eine zufällige Stelle an
    private void kreuzRand ()
    {
        if (randomizer && starter && !gewinner)
        {
            int x = 0;
            int y = 0;
            kreuzung();
            blocker();
            if (!siegPruefer) {
                for (int i = 0; i <= 72; i++) {
                    Random rand = new Random();
                    x = rand.nextInt(3);
                    y = rand.nextInt(3);

                    if (spielFeld[x][y].equals("0")) {
                        spielFeld[x][y] = "X";
                        ankreuzer(x, y, 'X');
                        gerade += 1;
                        break;
                    }
                }
            }
        }
    }

    //kreuzt per Zufall irgend ein freies Feld an
    private void zufallZug ()
    {
        randomizer = true;
        kreuzRand();
        randomizer = false;
    }

    //Wenn Kreis gewinnen könnte soll CPU Blocken
    private void blocker ()
    {
        if (!siegPruefer) {

            siegPruefer = false;

            //Reihe V, Links
            if (spielFeld[0][0].equals("0") && spielFeld[1][0].equals("o") && spielFeld[2][0].equals("o")) {
                zugCPUs(0, 0);
                siegPruefer = true;
            } else if (spielFeld[0][0].equals("o") && spielFeld[1][0].equals("0") && spielFeld[2][0].equals("o")) {
                zugCPUs(1, 0);
                siegPruefer = true;
            } else if (spielFeld[0][0].equals("o") && spielFeld[1][0].equals("o") && spielFeld[2][0].equals("0")) {
                zugCPUs(2, 0);
                siegPruefer = true;
            }

            //Reihe V, Mitte
            else if (spielFeld[0][1].equals("0") && spielFeld[1][1].equals("o") && spielFeld[2][1].equals("o")) {
                zugCPUs(0, 1);
                siegPruefer = true;
            } else if (spielFeld[0][1].equals("o") && spielFeld[1][1].equals("0") && spielFeld[2][1].equals("o")) {
                zugCPUs(1, 1);
                siegPruefer = true;
            } else if (spielFeld[0][1].equals("o") && spielFeld[1][1].equals("o") && spielFeld[2][1].equals("0")) {
                zugCPUs(2, 1);
                siegPruefer = true;
            }

            //Reihe V, Rechts
            else if (spielFeld[0][2].equals("0") && spielFeld[1][2].equals("o") && spielFeld[2][2].equals("o")) {
                zugCPUs(0, 2);
                siegPruefer = true;
            } else if (spielFeld[0][2].equals("o") && spielFeld[1][2].equals("0") && spielFeld[2][2].equals("o")) {
                zugCPUs(1, 2);
                siegPruefer = true;
            } else if (spielFeld[0][2].equals("o") && spielFeld[1][2].equals("o") && spielFeld[2][2].equals("0")) {
                zugCPUs(2, 2);
                siegPruefer = true;
            }

            //Reihe H, Oben
            else if (spielFeld[0][0].equals("0") && spielFeld[0][1].equals("o") && spielFeld[0][2].equals("o")) {
                zugCPUs(0, 0);
                siegPruefer = true;
            } else if (spielFeld[0][0].equals("o") && spielFeld[0][1].equals("0") && spielFeld[0][2].equals("o")) {
                zugCPUs(0, 1);
                siegPruefer = true;
            } else if (spielFeld[0][0].equals("o") && spielFeld[0][1].equals("o") && spielFeld[0][2].equals("0")) {
                zugCPUs(0, 2);
                siegPruefer = true;
            }

            //Reihe H, Mitte
            else if (spielFeld[1][0].equals("0") && spielFeld[1][1].equals("o") && spielFeld[1][2].equals("o")) {
                zugCPUs(1, 0);
                siegPruefer = true;
            } else if (spielFeld[1][0].equals("o") && spielFeld[1][1].equals("0") && spielFeld[1][2].equals("o")) {
                zugCPUs(1, 1);
                siegPruefer = true;
            } else if (spielFeld[1][0].equals("o") && spielFeld[1][1].equals("o") && spielFeld[1][2].equals("0")) {
                zugCPUs(1, 2);
                siegPruefer = true;
            }

            //Reihe H, Unten
            else if (spielFeld[2][0].equals("0") && spielFeld[2][1].equals("o") && spielFeld[2][2].equals("o")) {
                zugCPUs(2, 0);
                siegPruefer = true;
            } else if (spielFeld[2][0].equals("o") && spielFeld[2][1].equals("0") && spielFeld[2][2].equals("o")) {
                zugCPUs(2, 1);
                siegPruefer = true;
            } else if (spielFeld[2][0].equals("o") && spielFeld[2][1].equals("o") && spielFeld[2][2].equals("0")) {
                zugCPUs(2, 2);
                siegPruefer = true;
            }

            //Diagonal obenL nach untenR
            else if (spielFeld[0][0].equals("0") && spielFeld[1][1].equals("o") && spielFeld[2][2].equals("o")) {
                zugCPUs(0, 0);
                siegPruefer = true;
            } else if (spielFeld[0][0].equals("o") && spielFeld[1][1].equals("0") && spielFeld[2][2].equals("o")) {
                zugCPUs(1, 1);
                siegPruefer = true;
            } else if (spielFeld[0][0].equals("o") && spielFeld[1][1].equals("o") && spielFeld[2][2].equals("0")) {
                zugCPUs(2, 2);
                siegPruefer = true;
            }

            //Diagonal untenL nach obenR
            else if (spielFeld[2][0].equals("0") && spielFeld[1][1].equals("o") && spielFeld[0][2].equals("o")) {
                zugCPUs(2, 0);
                siegPruefer = true;
            } else if (spielFeld[2][0].equals("o") && spielFeld[1][1].equals("0") && spielFeld[0][2].equals("o")) {
                zugCPUs(1, 1);
                siegPruefer = true;
            } else if (spielFeld[2][0].equals("o") && spielFeld[1][1].equals("o") && spielFeld[0][2].equals("0")) {
                zugCPUs(0, 2);
                siegPruefer = true;
            }
        }
    }

    //Starte Spiel gegen schwere KI
    private void starteCpuS ()
    {
        neutralisiereSpielfeld();
        schwer = true;
        schwereCPU();
    }

    //überprüft ob ein Sieg für die KI möglich ist
    private void kreuzung ()
    {
        siegPruefer = false;

        //Reihe V, Links
        if (spielFeld[0][0].equals("0") && spielFeld[1][0].equals("X") && spielFeld[2][0].equals("X")) {
            zugCPUs(0, 0);
            siegPruefer = true;
        }
        else if (spielFeld[0][0].equals("X") && spielFeld[1][0].equals("0") && spielFeld[2][0].equals("X")) {
            zugCPUs(1, 0);
            siegPruefer = true;
        }
        else if (spielFeld[0][0].equals("X") && spielFeld[1][0].equals("X") && spielFeld[2][0].equals("0")) {
            zugCPUs(2, 0);
            siegPruefer = true;
        }

        //Reihe V, Mitte
        else if (spielFeld[0][1].equals("0") && spielFeld[1][1].equals("X") && spielFeld[2][1].equals("X")) {
            zugCPUs(0, 1);
            siegPruefer = true;
        }
        else if (spielFeld[0][1].equals("X") && spielFeld[1][1].equals("0") && spielFeld[2][1].equals("X")) {
            zugCPUs(1, 1);
            siegPruefer = true;
        }
        else if (spielFeld[0][1].equals("X") && spielFeld[1][1].equals("X") && spielFeld[2][1].equals("0")) {
            zugCPUs(2, 1);
            siegPruefer = true;
        }

        //Reihe V, Rechts
        else if (spielFeld[0][2].equals("0") && spielFeld[1][2].equals("X") && spielFeld[2][2].equals("X")) {
            zugCPUs(0, 2);
            siegPruefer = true;
        }
        else if (spielFeld[0][2].equals("X") && spielFeld[1][2].equals("0") && spielFeld[2][2].equals("X")) {
            zugCPUs(1, 2);
            siegPruefer = true;
        }
        else if (spielFeld[0][2].equals("X") && spielFeld[1][2].equals("X") && spielFeld[2][2].equals("0")) {
            zugCPUs(2, 2);
            siegPruefer = true;
        }

        //Reihe H, Oben
        else if (spielFeld[0][0].equals("0") && spielFeld[0][1].equals("X") && spielFeld[0][2].equals("X")) {
            zugCPUs(0, 0);
            siegPruefer = true;
        }
        else if (spielFeld[0][0].equals("X") && spielFeld[0][1].equals("0") && spielFeld[0][2].equals("X")) {
            zugCPUs(0, 1);
            siegPruefer = true;
        }
        else if (spielFeld[0][0].equals("X") && spielFeld[0][1].equals("X") && spielFeld[0][2].equals("0")) {
            zugCPUs(0, 2);
            siegPruefer = true;
        }

        //Reihe H, Mitte
        else if (spielFeld[1][0].equals("0") && spielFeld[1][1].equals("X") && spielFeld[1][2].equals("X")) {
            zugCPUs(1, 0);
            siegPruefer = true;
        }
        else if (spielFeld[1][0].equals("X") && spielFeld[1][1].equals("0") && spielFeld[1][2].equals("X")) {
            zugCPUs(1, 1);
            siegPruefer = true;
        }
        else if (spielFeld[1][0].equals("X") && spielFeld[1][1].equals("X") && spielFeld[1][2].equals("0")) {
            zugCPUs(1, 2);
            siegPruefer = true;
        }

        //Reihe H, Unten
        else if (spielFeld[2][0].equals("0") && spielFeld[2][1].equals("X") && spielFeld[2][2].equals("X")) {
            zugCPUs(2, 0);
            siegPruefer = true;
        }
        else if (spielFeld[2][0].equals("X") && spielFeld[2][1].equals("0") && spielFeld[2][2].equals("X")) {
            zugCPUs(2, 1);
            siegPruefer = true;
        }
        else if (spielFeld[2][0].equals("X") && spielFeld[2][1].equals("X") && spielFeld[2][2].equals("0")) {
            zugCPUs(2, 2);
            siegPruefer = true;
        }

        //Diagonal obenL nach untenR
        else if (spielFeld[0][0].equals("0") && spielFeld[1][1].equals("X") && spielFeld[2][2].equals("X")) {
            zugCPUs(0, 0);
            siegPruefer = true;
        }
        else if (spielFeld[0][0].equals("X") && spielFeld[1][1].equals("0") && spielFeld[2][2].equals("X")) {
            zugCPUs(1, 1);
            siegPruefer = true;
        }
        else if (spielFeld[0][0].equals("X") && spielFeld[1][1].equals("X") && spielFeld[2][2].equals("0")) {
            zugCPUs(2, 2);
            siegPruefer = true;
        }

        //Diagonal untenL nach obenR
        else if (spielFeld[2][0].equals("0") && spielFeld[1][1].equals("X") && spielFeld[0][2].equals("X")) {
            zugCPUs(2, 0);
            siegPruefer = true;
        }
        else if (spielFeld[2][0].equals("X") && spielFeld[1][1].equals("0") && spielFeld[0][2].equals("X")) {
            zugCPUs(1, 1);
            siegPruefer = true;
        }
        else if (spielFeld[2][0].equals("X") && spielFeld[1][1].equals("X") && spielFeld[0][2].equals("0")) {
            zugCPUs(0, 2);
            siegPruefer = true;
        }
    }

    //Zug für die schwere KI
    private void zugCPUs (int x, int y)
    {
        spielFeld[x][y] = "X";
        ankreuzer(x, y, 'X');
        gerade += 1;
    }

    //KI für die schwere KI
    private void schwereCPU ()
    {
        if (schwer && !gewinner) {
            int a ;

            if (gerade == 0) {
                Random rand = new Random();
                int zufall = rand.nextInt(4);

                switch (zufall) {
                    case 0:
                        zugCPUs(0, 0);
                        break;

                    case 1:
                        zugCPUs(0, 2);
                        break;

                    case 2:
                        zugCPUs(2, 0);
                        break;

                    case 3:
                        zugCPUs(2, 2);
                        break;
                }
            }
            else if (gerade == 2)
            {
                //Case 0 Kreis in Mitte
                if (spielFeld[0][0].equals("X") && spielFeld[1][1].equals("o")) zugCPUs(2, 2);
                //Case 1 in Mitte
                else if (spielFeld[0][2].equals("X") && spielFeld[1][1].equals("o")) zugCPUs(2, 0);
                //Case 2 in Mitte
                else if (spielFeld[2][0].equals("X") && spielFeld[1][1].equals("o")) zugCPUs(0, 2);
                //Case 3 in Mitte
                else if (spielFeld[2][2].equals("X") && spielFeld[1][1].equals("o")) zugCPUs(0, 0);
                //Case 0 neben Mitte
                else if (spielFeld[0][0].equals("X") && (spielFeld[0][1].equals("o") || spielFeld[1][0].equals("o")
                        || spielFeld[2][1].equals("o") || spielFeld[1][2].equals("o")))
                {
                    if (spielFeld[0][1].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(2, 0);
                        else if (a == 1) zugCPUs(1, 1);
                    }
                    else if (spielFeld[1][0].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 2);
                        else if (a == 1) zugCPUs(1, 1);
                    }
                    else if (spielFeld[1][2].equals("o"))
                    {
                        a = randominator(3);
                        if (a == 0) zugCPUs(0, 2);
                        else if (a == 1) zugCPUs(1, 1);
                        else if (a == 2) zugCPUs(2, 0);
                    }
                    else if (spielFeld[2][1].equals("o"))
                    {
                        a = randominator(3);
                        if (a == 0) zugCPUs(0, 2);
                        else if (a == 1) zugCPUs(1, 1);
                        else if (a == 2) zugCPUs(2, 0);
                    }
                }
                //Case 0 am Rand
                else if (spielFeld[0][0].equals("X") && (spielFeld[0][2].equals("o") || spielFeld[2][0].equals("o")
                        || spielFeld[2][2].equals("o")))
                {
                    if (spielFeld[0][2].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(2, 0);
                        else if (a == 1) zugCPUs(2, 2);
                    }
                    else if (spielFeld[2][0].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 2);
                        else if (a == 1) zugCPUs(2, 2);
                    }
                    else if (spielFeld[2][2].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 2);
                        else if (a == 1) zugCPUs(2, 0);
                    }
                }
                //Case 1 neben Mitte
                else if (spielFeld[0][2].equals("X") && (spielFeld[0][1].equals("o") || spielFeld[1][0].equals("o")
                        || spielFeld[2][1].equals("o") || spielFeld[1][2].equals("o")))
                {
                    if (spielFeld[0][1].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(2, 2);
                        else if (a == 1) zugCPUs(1, 1);
                    }
                    else if (spielFeld[1][0].equals("o"))
                    {
                        a = randominator(3);
                        if (a == 0) zugCPUs(0, 0);
                        else if (a == 1) zugCPUs(1, 1);
                        else if (a == 2) zugCPUs(2, 2);
                    }
                    else if (spielFeld[1][2].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 0);
                        else if (a == 1) zugCPUs(1, 1);
                    }
                    else if (spielFeld[2][1].equals("o"))
                    {
                        a = randominator(3);
                        if (a == 0) zugCPUs(0, 0);
                        else if (a == 1) zugCPUs(1, 1);
                        else if (a == 2) zugCPUs(2, 2);
                    }

                }
                //Case 1 am Rand
                else if (spielFeld[0][2].equals("X") && (spielFeld[0][0].equals("o") || spielFeld[2][0].equals("o")
                        || spielFeld[2][2].equals("o")))
                {
                    if (spielFeld[0][0].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(2, 0);
                        else if (a == 1) zugCPUs(2, 2);
                    }
                    else if (spielFeld[2][0].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 0);
                        else if (a == 1) zugCPUs(2, 2);
                    }
                    else if (spielFeld[2][2].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 0);
                        else if (a == 1) zugCPUs(2, 0);
                    }
                }
                //Case 2 neben Mitte
                else if (spielFeld[2][0].equals("X") && (spielFeld[0][1].equals("o") || spielFeld[1][0].equals("o")
                        || spielFeld[2][1].equals("o") || spielFeld[1][2].equals("o")))
                {
                    if (spielFeld[0][1].equals("o"))
                    {
                        a = randominator(3);
                        if (a == 0) zugCPUs(0, 0);
                        else if (a == 1) zugCPUs(1, 1);
                        else if (a == 2) zugCPUs(2, 2);
                    }
                    else if (spielFeld[1][0].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(2, 2);
                        else if (a == 1) zugCPUs(1, 1);
                    }
                    else if (spielFeld[1][2].equals("o"))
                    {
                        a = randominator(3);
                        if (a == 0) zugCPUs(0, 0);
                        else if (a == 1) zugCPUs(1, 1);
                        else if (a == 2) zugCPUs(2, 2);
                    }
                    else if (spielFeld[2][1].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 0);
                        else if (a == 1) zugCPUs(1, 1);
                    }
                }
                //Case 2 am Rand
                else if (spielFeld[2][0].equals("X") && (spielFeld[0][0].equals("o") || spielFeld[0][2].equals("o")
                        || spielFeld[2][2].equals("o")))
                {
                    if (spielFeld[0][0].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 2);
                        else if (a == 1) zugCPUs(2, 2);
                    }
                    else if (spielFeld[0][2].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 0);
                        else if (a == 1) zugCPUs(2, 2);
                    }
                    else if (spielFeld[2][2].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 0);
                        else if (a == 1) zugCPUs(0, 2);
                    }
                }
                //Case 3 neben Mitte
                else if (spielFeld[2][2].equals("X") && (spielFeld[0][1].equals("o") || spielFeld[1][0].equals("o")
                        || spielFeld[2][1].equals("o") || spielFeld[1][2].equals("o")))
                {
                    if (spielFeld[0][1].equals("o"))
                    {
                        a = randominator(3);
                        if (a == 0) zugCPUs(0, 2);
                        else if (a == 1) zugCPUs(1, 1);
                        else if (a == 2) zugCPUs(2, 0);
                    }
                    else if (spielFeld[1][0].equals("o"))
                    {
                        a = randominator(3);
                        if (a == 0) zugCPUs(0, 2);
                        else if (a == 1) zugCPUs(1, 1);
                        else if (a == 2) zugCPUs(2, 0);
                    }
                    else if (spielFeld[1][2].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(2, 0);
                        else if (a == 1) zugCPUs(1, 1);
                    }
                    else if (spielFeld[2][1].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 2);
                        else if (a == 1) zugCPUs(1, 1);
                    }
                }
                //Case 3 am Rand
                else if (spielFeld[2][2].equals("X") && (spielFeld[0][0].equals("o") || spielFeld[0][2].equals("o")
                        || spielFeld[2][0].equals("o")))
                {
                    if (spielFeld[0][0].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 2);
                        else if (a == 1) zugCPUs(2, 0);
                    }
                    else if (spielFeld[0][2].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 0);
                        else if (a == 1) zugCPUs(2, 0);
                    }
                    else if (spielFeld[2][0].equals("o"))
                    {
                        a = randominator(2);
                        if (a == 0) zugCPUs(0, 0);
                        else if (a == 1) zugCPUs(0, 2);
                    }
                }

                else zufallZug();
            }
            else if (gerade == 4)
            {
                kreuzung();
                blocker();

                if (!siegPruefer) {
                    //Case 0
                    if (spielFeld[0][0].equals("X") && spielFeld[1][1].equals("o") && spielFeld[2][2].equals("X") &&
                            (spielFeld[2][0].equals("o") || spielFeld[0][2].equals("o")))
                    {
                        if (spielFeld[2][0].equals("o")) zugCPUs(0, 2);
                        else if (spielFeld[0][2].equals("o")) zugCPUs(2, 0);
                    }
                    //Case 1
                    else if (spielFeld[0][2].equals("X") && spielFeld[1][1].equals("o") && spielFeld[2][0].equals("X") &&
                            (spielFeld[0][0].equals("o") || spielFeld[2][2].equals("o")))
                    {
                        if (spielFeld[0][0].equals("o")) zugCPUs(2, 2);
                        else if (spielFeld[2][2].equals("o")) zugCPUs(0, 0);
                    }
                    //Case 0 wenn Kreis direkt neben Kreuz
                    else if (spielFeld[0][0].equals("X") && spielFeld[1][1].equals("X") && spielFeld[0][1].equals("o")
                            && spielFeld[2][2].equals("o") && spielFeld[2][0].equals("0")) zugCPUs(2, 0);

                    else if (spielFeld[0][0].equals("X") && spielFeld[2][0].equals("X") && spielFeld[0][1].equals("o")
                            && spielFeld[1][0].equals("o") && spielFeld[2][2].equals("0")) zugCPUs(2, 2);

                    else if (spielFeld[0][0].equals("X") && spielFeld[1][1].equals("X") && spielFeld[1][0].equals("o")
                            && spielFeld[2][2].equals("o") && spielFeld[0][2].equals("0")) zugCPUs(0, 2);

                    else if (spielFeld[0][0].equals("X") && spielFeld[0][2].equals("X") && spielFeld[0][1].equals("o")
                            && spielFeld[1][0].equals("o") && spielFeld[2][2].equals("0")) zugCPUs(2, 2);

                    //Case 1 wenn Kreis direkt neben Kreuz
                    else if (spielFeld[0][2].equals("X") && spielFeld[1][1].equals("X") && spielFeld[1][2].equals("o")
                            && spielFeld[2][0].equals("o") && spielFeld[0][0].equals("0")) zugCPUs(0, 0);

                    else if (spielFeld[0][0].equals("X") && spielFeld[0][2].equals("X") && spielFeld[1][2].equals("o")
                            && spielFeld[0][1].equals("o") && spielFeld[2][0].equals("0")) zugCPUs(2, 0);

                    else if (spielFeld[0][2].equals("X") && spielFeld[1][1].equals("X") && spielFeld[0][1].equals("o")
                            && spielFeld[2][0].equals("o") && spielFeld[2][2].equals("0")) zugCPUs(2, 2);

                    else if (spielFeld[0][2].equals("X") && spielFeld[2][2].equals("X") && spielFeld[1][2].equals("o")
                            && spielFeld[0][1].equals("o") && spielFeld[2][0].equals("0")) zugCPUs(2, 0);

                    //Case 2 wenn Kreis direkt neben Kreuz
                    else if (spielFeld[2][0].equals("X") && spielFeld[1][1].equals("X") && spielFeld[1][0].equals("o")
                            && spielFeld[0][2].equals("o") && spielFeld[2][2].equals("0")) zugCPUs(2, 2);

                    else if (spielFeld[2][0].equals("X") && spielFeld[2][2].equals("X") && spielFeld[1][0].equals("o")
                            && spielFeld[2][1].equals("o") && spielFeld[0][2].equals("0")) zugCPUs(0, 2);

                    else if (spielFeld[2][0].equals("X") && spielFeld[1][1].equals("X") && spielFeld[2][1].equals("o")
                            && spielFeld[0][2].equals("o") && spielFeld[0][0].equals("0")) zugCPUs(0, 0);

                    else if (spielFeld[0][0].equals("X") && spielFeld[2][0].equals("X") && spielFeld[1][0].equals("o")
                            && spielFeld[2][1].equals("o") && spielFeld[0][2].equals("0")) zugCPUs(0, 2);

                    //Case 3 wenn Kreis direkt neben Kreuz
                    else if (spielFeld[2][2].equals("X") && spielFeld[1][1].equals("X") && spielFeld[0][0].equals("o")
                            && spielFeld[2][1].equals("o") && spielFeld[0][2].equals("0")) zugCPUs(0, 2);

                    else if (spielFeld[2][2].equals("X") && spielFeld[0][2].equals("X") && spielFeld[1][2].equals("o")
                            && spielFeld[2][1].equals("o") && spielFeld[0][0].equals("0")) zugCPUs(0, 0);

                    else if (spielFeld[2][2].equals("X") && spielFeld[1][1].equals("X") && spielFeld[1][2].equals("o")
                            && spielFeld[0][0].equals("o") && spielFeld[2][0].equals("0")) zugCPUs(2, 0);

                    else if (spielFeld[2][0].equals("X") && spielFeld[2][2].equals("X") && spielFeld[2][1].equals("o")
                            && spielFeld[1][2].equals("o") && spielFeld[0][0].equals("0")) zugCPUs(0, 0);

                    //Case 0 wenn vorher Rand rechts oben angekreuzt wurde
                    else if (spielFeld[0][0].equals("X") && spielFeld[2][0].equals("X") && spielFeld[0][2].equals("o")
                            && spielFeld[1][0].equals("o") && spielFeld[2][2].equals("0")) zugCPUs(2, 2);

                    else if (spielFeld[0][0].equals("X") && spielFeld[2][2].equals("X") && spielFeld[0][2].equals("o")
                            && spielFeld[1][1].equals("o") && spielFeld[2][0].equals("0")) zugCPUs(2, 0);

                    //Case 0 wenn vorher Rand links unten angekreuzt wurde
                    else if (spielFeld[0][0].equals("X") && spielFeld[0][2].equals("X") && spielFeld[0][1].equals("o")
                            && spielFeld[2][0].equals("o") && spielFeld[2][2].equals("0")) zugCPUs(2, 2);

                    else if (spielFeld[0][0].equals("X") && spielFeld[2][2].equals("X") && spielFeld[1][1].equals("o")
                            && spielFeld[2][0].equals("o") && spielFeld[0][2].equals("0")) zugCPUs(0, 2);

                    //Case 0 wenn vorher Rand rechts unten angekreuzt wurde
                    else if (spielFeld[0][0].equals("X") && spielFeld[2][0].equals("X") && spielFeld[1][0].equals("o")
                            && spielFeld[2][2].equals("o") && spielFeld[0][2].equals("0")) zugCPUs(0, 2);

                    else if (spielFeld[0][0].equals("X") && spielFeld[0][2].equals("X") && spielFeld[0][1].equals("o")
                            && spielFeld[2][2].equals("o") && spielFeld[2][0].equals("0")) zugCPUs(2, 0);

                    //Case 1 wenn vorher Rand links oben angekreuzt wurde
                    else if (spielFeld[0][2].equals("X") && spielFeld[2][0].equals("X") && spielFeld[0][0].equals("o")
                            && spielFeld[1][1].equals("o") && spielFeld[2][2].equals("0")) zugCPUs(2, 2);

                    else if (spielFeld[0][2].equals("X") && spielFeld[2][2].equals("X") && spielFeld[0][0].equals("o")
                            && spielFeld[1][2].equals("o") && spielFeld[2][0].equals("0")) zugCPUs(2, 0);

                    //Case 1 wenn vorher Rand links unten angekreuzt wurde
                    else if (spielFeld[0][2].equals("X") && spielFeld[2][2].equals("X") && spielFeld[1][2].equals("o")
                            && spielFeld[2][0].equals("o") && spielFeld[0][0].equals("0")) zugCPUs(0, 0);

                    //Case 1 wenn vorher Rand rechts unten angekreuzt wurde
                    else if (spielFeld[0][2].equals("X") && spielFeld[2][0].equals("X") && spielFeld[1][1].equals("o")
                            && spielFeld[2][2].equals("o") && spielFeld[0][0].equals("0")) zugCPUs(0, 0);

                    //Case 2 wenn vorher Rand links oben angekreuzt wurde
                    else if (spielFeld[2][0].equals("X") && spielFeld[0][2].equals("X") && spielFeld[0][0].equals("o")
                            && spielFeld[1][1].equals("o") && spielFeld[2][2].equals("0")) zugCPUs(2, 2);

                    else if (spielFeld[2][0].equals("X") && spielFeld[2][2].equals("X") && spielFeld[0][0].equals("o")
                            && spielFeld[2][1].equals("o") && spielFeld[0][2].equals("0")) zugCPUs(0, 2);

                    //Case 2 wenn vorher Rand rechts oben angekreuzt wurde
                    else if (spielFeld[2][0].equals("X") && spielFeld[2][2].equals("X") && spielFeld[0][2].equals("o")
                            && spielFeld[2][1].equals("o") && spielFeld[0][0].equals("0")) zugCPUs(0, 0);

                    //Case 3 wenn vorher Rand links oben angekreuzt wurde
                    else if (spielFeld[0][2].equals("X") && spielFeld[2][2].equals("X") && spielFeld[0][0].equals("o")
                            && spielFeld[2][1].equals("o") && spielFeld[2][0].equals("0")) zugCPUs(2, 0);

                    else if (spielFeld[2][0].equals("X") && spielFeld[2][0].equals("X") && spielFeld[0][0].equals("o")
                            && spielFeld[2][1].equals("o") && spielFeld[0][2].equals("0")) zugCPUs(0, 2);

                    //Case 3 wenn vorher Rand links unten angekreuzt wurde
                    else if (spielFeld[0][2].equals("X") && spielFeld[2][2].equals("X") && spielFeld[1][2].equals("o")
                            && spielFeld[2][2].equals("o") && spielFeld[0][0].equals("0")) zugCPUs(0, 0);


                    else zufallZug();
                }
            }
            else if (gerade == 6)
            {
                kreuzung();
                blocker();

                if (!siegPruefer) {
                    //Case 0 oben rechts
                    if (spielFeld[0][0].equals("X") && spielFeld[1][1].equals("o") && spielFeld[2][2].equals("X")
                            && spielFeld[2][0].equals("o") && (spielFeld[0][1].equals("o") || spielFeld[1][2].equals("o")))
                    {
                        if (spielFeld[0][1].equals("o")) zugCPUs(1, 2);
                        else if (spielFeld[1][2].equals("o")) zugCPUs(0, 1);
                    }
                    //Case 0 unten links
                    else if (spielFeld[0][0].equals("X") && spielFeld[1][1].equals("o") && spielFeld[2][2].equals("X")
                            && spielFeld[0][2].equals("o") && (spielFeld[1][0].equals("o") || spielFeld[2][1].equals("o")))
                    {
                        if (spielFeld[1][0].equals("o")) zugCPUs(2, 1);
                        else if (spielFeld[2][1].equals("o")) zugCPUs(1, 0);
                    }
                    //Case 1 oben links
                    else if (spielFeld[0][2].equals("X") && spielFeld[1][1].equals("o") && spielFeld[2][0].equals("X")
                            && spielFeld[2][2].equals("o") && (spielFeld[0][1].equals("o") || spielFeld[1][0].equals("o")))
                    {
                        if (spielFeld[0][1].equals("o")) zugCPUs(1, 0);
                        else if (spielFeld[1][0].equals("o")) zugCPUs(0, 1);
                    }
                    //Case 1 unten rechts
                    else if (spielFeld[0][2].equals("X") && spielFeld[1][1].equals("o") && spielFeld[2][0].equals("X")
                            && spielFeld[0][0].equals("o") && (spielFeld[2][1].equals("o") || spielFeld[1][2].equals("o")))
                    {
                        if (spielFeld[2][1].equals("o")) zugCPUs(1, 2);
                        else if (spielFeld[1][2].equals("o")) zugCPUs(2, 1);
                    }

                    else zufallZug();
                }
            }

            else if (gerade == 8)
            {
                blocker();
                zufallZug();
            }
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Tic Tac Toe ist super und garantiert besser als Schach!!1");
        frame.setContentPane(new Toe_GUI().Paneel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private Toe_GUI ()
    {
        a1.addActionListener(e -> buttonClicked(0, 0));

        a2.addActionListener(e -> buttonClicked(0, 1));

        a3.addActionListener(e -> buttonClicked(0, 2));

        b1.addActionListener(e -> buttonClicked(1, 0));

        b2.addActionListener(e -> buttonClicked(1, 1));

        b3.addActionListener(e -> buttonClicked(1, 2));

        c1.addActionListener(e -> buttonClicked(2, 0));

        c2.addActionListener(e -> buttonClicked(2, 1));

        c3.addActionListener(e -> buttonClicked(2, 2));

        spielStarten.addActionListener(e -> starteSpiel());

        cpuLeicht.addActionListener(e -> starteCpuL());

        cpuSchwer.addActionListener(e -> starteCpuS());
    }
}
