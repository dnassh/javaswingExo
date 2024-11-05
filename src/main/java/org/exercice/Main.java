package org.exercice;

import org.exercice.model.Spectacle;
import org.exercice.model.SpectacleTable;
import org.exercice.service.ButtonEditor;
import org.exercice.service.ButtonRenderer;
import org.exercice.service.DataReader;
import org.exercice.view.MainView;


import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int LEFT_MENU_BUTTONS_SIZE = 200;
    static List<Spectacle> listeDesSpectacles = new ArrayList<>();
    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        String fileName = "spectacles.txt";
        listeDesSpectacles = DataReader.read(fileName);
        MainView mainView = new MainView();
        JFrame mainFrame = mainView.render();
        JPanel mainPane = new JPanel(new BorderLayout(10,10));


        JPanel leftMenuButtons = new JPanel();
        GridLayout layout = new GridLayout(4,1);
        layout.setVgap(5);
        leftMenuButtons.setLayout(layout);
        JButton listBtn = new JButton("Liste des spectacles");
        listBtn.setPreferredSize(new Dimension(LEFT_MENU_BUTTONS_SIZE,25));
        JButton addBtn = new JButton("Ajouter un spectacle");
        addBtn.setPreferredSize(new Dimension(LEFT_MENU_BUTTONS_SIZE,25));
        JButton importBtn = new JButton("Importer des spectacles");
        importBtn.setBackground(new Color(30,135,230));
        importBtn.setPreferredSize(new Dimension(LEFT_MENU_BUTTONS_SIZE,25));

        leftMenuButtons.add(listBtn);
        leftMenuButtons.add(addBtn);
        leftMenuButtons.add(new JSeparator());
        leftMenuButtons.add(importBtn);
//        JButton testBtn2 = new JButton("OUEST");
//        JButton testBtn3 = new JButton("NORD");
        JButton testBtn4 = new JButton("SUD");
        JLabel testBtn5 = new JLabel("CENTRE");

        JPanel leftPane = new JPanel();
        JPanel rightPane = new JPanel();
        JPanel topPane = new JPanel();
        JPanel bottomPane = new JPanel();

        SpectacleTable spectacleModel = new SpectacleTable(listeDesSpectacles);
        JTable liste = new JTable(spectacleModel);

        liste.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        liste.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(liste, listeDesSpectacles, spectacleModel));

        TableColumn column = liste.getColumnModel().getColumn(5);
        column.setMinWidth(150);

        JScrollPane centerPane = new JScrollPane (liste,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        leftPane.add(leftMenuButtons);
//        rightPane.add(testBtn2);
//        topPane.add(testBtn3);
        bottomPane.add(testBtn4);

        mainPane.add(leftPane,BorderLayout.WEST);
        mainPane.add(rightPane,BorderLayout.EAST);
        mainPane.add(topPane,BorderLayout.NORTH);
        mainPane.add(bottomPane,BorderLayout.SOUTH);
        mainPane.add(centerPane,BorderLayout.CENTER);

        mainFrame.setJMenuBar(createMenu());
        mainFrame.add(mainPane);
        mainFrame.setVisible(true);

    }

    private static JMenuBar createMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Fichier");
        JMenu helpMenu = new JMenu("Aide");
        JMenuItem newItem = new JMenuItem("Nouveau");
        JMenuItem importItem = new JMenuItem("Importer des spectacles");
        JMenuItem quite = new JMenuItem("Quitter");
        JSeparator sp = new JSeparator();
        fileMenu.add(newItem);
        fileMenu.add(importItem);
        fileMenu.add(sp);
        fileMenu.add(quite);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        return menuBar;
    }
}