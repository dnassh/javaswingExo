package org.exercice.view;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.*;

public class MainView {

    public JFrame render() throws UnsupportedLookAndFeelException {
        FlatMacDarkLaf.setup();
        UIManager.setLookAndFeel(new FlatMacDarkLaf());
        JFrame mainView = new JFrame("Gestion des spectacle");
        mainView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainView.setMinimumSize(new Dimension(800,600));
        mainView.setLocationRelativeTo(null);

        return  mainView;
    }

}
