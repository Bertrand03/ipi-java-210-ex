package com.ipiecoles.java.java210;

import com.sun.org.apache.xml.internal.utils.StringToIntTable;

import java.util.Scanner;

public class Sudoku {
	public static final String FIN_SAISIE = "FIN";
	public static boolean resolu = false;
	short sudokuAResoudre[][];

	public short[][] getSudokuAResoudre() {
		return sudokuAResoudre;
	}

	public void setSudokuAResoudre(short[][] tab) {
		sudokuAResoudre = tab;
	}


	/**
	 * Constructeur par défaut
	 */


	public Sudoku() {
		sudokuAResoudre = new short[9][9];
		// ou setSudokuAResoudre = (new short [9][9])
	}

	public static boolean ligneSaisieEstCoherente(String ligneSaisie) {
		//Ligne nulle ou vide

		if (ligneSaisie == null || ligneSaisie.trim().equals("")) {
			System.out.println("Les coordonnées du chiffre et/ou sa valeur ne peuvent pas être nulles, vides ou remplies avec des espaces");
			return false;   // Le return sort de la fonction (code mort)
		}
		// La ligne ne faisant pas trois caractères
		else if
				(ligneSaisie.length() != 3) {
			System.out.println("Les coordonnées du chiffre et/ou sa valeur doit faire 3 caractères");
			return false;
		} else if (!ligneSaisie.matches("[0-8][0-8][1-9]"))
		{
			System.out.println("L'abscisse et l'ordonnée doivent être compris entre 0 et 8, la valeur entre 1 et 9");

			return false;
		}
			return true;
	}




	/**
	 * Cette méthode invite l'utilisateur à saisir un ensemble de coordonnées pour initialiser un sudoku à résoudre.
	 * Les coordonnées prennent la forme XYZ avec X correspondant à l'ligne, Y l'ordonnée et Z la valeur. Seules les
	 * chiffres présents sont à saisir et l'utilisateur doit appuyer sur entrée après chaque saisie. 
	 * Lorsqu'il a terminé sa saisie, il entre la chaîne FIN. La fonction remplit au fur et à mesure un tableau de String
	 * comportant les coordonnées des chiffres saisis.
	 * 
	 * A noter que pour chaque ligne saisie, sa cohérence est vérifiée en appelant la méthode ligneSaisieEstCoherente
	 * En cas de mauvaise saisie, la saisie ne doit pas être prise en compte et l'utilisateur doit pouvoir saisie une nouvelle ligne
	 * La fonction doit également gérer le cas où l'utilisateur ne rentre rien mais appuye sur Entrée
	 *
	 * @return Un tableau comportant les coordonnées des chiffres présents dans le sudoku à résoudre
	 */
	public static String[] demandeCoordonneesSudoku() {
		// initialiser un tableau
		String[] tableauCocolonnes = new String[81];

		Scanner scanner = new Scanner(System.in);
		String ligneSaisie = scanner.nextLine();

		int i = 0;

		while (!ligneSaisie.equals("FIN")) {
			//Tester si la ligne est cohérente
			if (ligneSaisieEstCoherente(ligneSaisie)) { //Il va comparer la saisie utilisateur avec la fonction ligneSaisieEstCoherente
				//Si oui, je l'ajoute dans mon tableau.
				tableauCocolonnes[i] = ligneSaisie; //ligneSaisie prend la place de la coordonnée i du tableau
				i++; //Incrementation qui permet de changer de coordonnée dans le tableau. Si ligneSaisie, on passera
				//à une autre coordonnée du tableau qui aura la nouvelle valeur ligneSaisie
			} else {
				// Si non, je l'informe de son erreur et lui redemande de saisir de nouvelles coordonnées
				System.out.println("Les coordonnées du chiffre et/ou sa valeur ne sont pas cohérents. Merci de réessayer");
			}
			ligneSaisie = scanner.nextLine();
		}
		scanner.close();
		return tableauCocolonnes;
	}



	
	/**
	 * La méthode prend un tableau de coordonnées de chiffre soud la forme XYZ avec X correspondant 
	 * à l'ligne, Y l'ordonnée et Z la valeur et remplit le tableau sudokuAResoudre avec les bonnes valeurs
	 * au bon endroit. Ex 012, première ligne deuxième colonne, on met la valeur 2. Lorsqu'une valeur nulle est 
	 * rencontrée dans le tableau, on arrête le traitement
	 * 
	 * Pour passer d'une String à un short, on pourra utiliser la méthode stringToInt(string)
	 * 
	 * @param tableauCocolonnes
	 */
	public void remplitSudokuATrous(String[] tableauCocolonnes) {
		int ligne = 0;
		short colonne = 0;
		short valeur = 1;
		//Définir, ligne, colonne et valeur
		int i = 0;
		while (i < tableauCocolonnes.length && tableauCocolonnes[i] != null) {

			ligne = Short.parseShort(tableauCocolonnes[i].substring(0, 1)); // Passe du String à un short
			colonne = (short) Integer.parseInt(tableauCocolonnes[i].substring(1, 2));// (short) Integer.parseInt va convertir un short en Int
			valeur = Short.parseShort(tableauCocolonnes[i].substring(2, 3));

			sudokuAResoudre[ligne][colonne] = valeur; //Ici on integre la valeur dans le tableau sudokuAResoudre

			i++;
		}
	}
		// 2eme solution avec for

		/*for (int n = 0; n < tableauCocolonnes.length; n++;){
			if (tableauCocolonnes != null) {
				break;
			}
		}
		ligne = Short.parseShort (tableauCocolonnes [i].substring(0,1); // Passe du String à un short
		colonne = (short) Integer.parseInt(tableauCocolonnes[i].substring(1,2));// (short) Integer.parseInt va convertir un short en Int
		valeur = Short.parseShort(tableauCocolonnes[i].substring(2, 3);

		sudokuAResoudre [ligne] [colonne] = valeur //Ici on integre la valeur dans le tableau sudokuAResoudre
	}
*/


		/*stringToInt(ligne, colonne);
		Short.parseShort(valeur);
		//Parcourir le tableau tableauCoordonnées
			ligneSaisie.substring(0);
			ligneSaisie.substring(1);

		//Pour chacune de ces valeurs
		//=> extrait ligne, colonne et valeur

		//on met la valeur au bon endroit dans sudokuAResoudre
		sudokuAResoudre[ligne][colonne] = valeur
		

	
	private int stringToInt(String s) {
		return Integer.parseInt(s);
	}*/

		/**
		 * Cette méthode affiche un sudoku de manière formatée sur la console.
		 * Cela doit ressembler exactement à :
		 * -----------------------
		 * |   8   | 4   2 |   6   |
		 * |   3 4 |       | 9 1   |
		 * | 9 6   |       |   8 4 |
		 *  -----------------------
		 * |       | 2 1 6 |       |
		 * |       |       |       |
		 * |       | 3 5 7 |       |
		 *  -----------------------
		 * | 8 4   |       |   7 5 |
		 * |   2 6 |       | 1 3   |
		 * |   9   | 7   1 |   4   |
		 *  -----------------------
		 *
		 * @param sudoku tableau de short représentant les valeurs d'un sudoku (résolu ou non).
		 * Ce tableau fait 9 par 9 et contient des chiffres de 0 à 9, 0 correspondant à une valeur
		 * non trouvée (dans ce cas, le programme affiche un blanc à la place de 0
		 */

	public void ecrireSudoku(short[][] sudoku) {

		for (int i = 0; i < sudoku.length; i++)
		{
			//------------=> i = 0/3/6/9, nous servira à mettre les lignes horizontales
			if(i % 3 == 0) { //Si Modulo de trois est égale à O on affiche (O/3, 3/3 etc...)
				System.out.println(" -----------------------");
							}
				for (int j = 0; j < sudoku[i].length; j++)
				{
					// j 0 / 3 / 6 / 9
					if (j %3 ==0)
					{
						System.out.print("| ");
					}
					if(sudoku[i][j] == 0)
					{
						System.out.print("  ");
					}
					else
					{
					//Affiche chaque element de mon tableau à double dimensions
				System.out.print(sudoku[i][j] + " ");
					}
				}
		// j = 9eme
		System.out.println("|");
		}
		System.out.println(" -----------------------");

		}
	
	/**
	 * Cette méthode vérifie si un chiffre est autorisé à la position d'ligne et
	 * d'ordonnée donnés dans le sudoku en appliquant les règles suivantes : 
	 * 
	 * 1 : Si la valeur est déjà dans la ligne, le chiffre n'est pas autorisé
	 * 2 : Si le valeur est déjà dans la colone, le chiffre n'est pas autorisé
	 * 3 : Si la valeur est est déjà dans la boite, le chiffre n'est pas autorisé
	 * 
	 * @param ligne
	 * @param colonne
	 * @param chiffre
	 * @param sudoku
	 * @return
	 */
	public static boolean estAutorise(int ligne, int colonne, short chiffre, short[][] sudoku) {

		//Si la valeur est déjà dans la ligne, le chiffre n'est pas autorisé
		for (int j = 0; j < sudoku[ligne].length; j++) {
			if (chiffre == sudoku[ligne][j]) {
				return false;
			}
		}

		//Si la valeur est déjà dans la colonne, le chiffre n'est pas autorisé
		for (int i = 0; i < sudoku.length; i++) {
			if (chiffre == sudoku[i][colonne]) {
				return false;
			}
		}

		//Si la valeur est déjà dans la boîte le chiffre n'est pas autorisé
		//Commencer par écrire l'algo comme si on était sur la première boîte en haut à gauche

		int debutI = (ligne /3) * 3; //0-2 => 0 / 3-5 => 3 / 6-8 => 6
		int debutJ= (colonne /3) * 3;


		for (int i = debutI; i < debutI + 3; i++) {
			for (int j = debutJ; j <= debutJ + 3; j++) {
				if (sudoku[i][j] == chiffre) {
					return false;
				}
			}
		}

		//Si tout est ok, on renvoie vrai
		return true;
	}

	public boolean resoudre(int ligne, int colonne, short[][] sudoku) {
		return true;
    }
}
