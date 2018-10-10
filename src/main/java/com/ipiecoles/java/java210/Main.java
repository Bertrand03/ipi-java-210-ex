package com.ipiecoles.java.java210;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

    Sudoku monSudoku = new Sudoku();
    String[] coordonnees = monSudoku.demandeCoordonneesSudoku(); //demande coordonnées à l'utilisateur type String
    monSudoku.remplitSudokuATrous(coordonnees); // On intègre les données dans tableau remplitSudokuATrous
    monSudoku.ecrireSudoku(monSudoku.getSudokuAResoudre());
    // Résolution

    //Il y a une solution
    //monSudoku.ecrireSudoku(monSudoku.getSudokuAResoudre());

    //Il n'y a pas de solution
    //System.out.println("Pas de solution");

        }



}