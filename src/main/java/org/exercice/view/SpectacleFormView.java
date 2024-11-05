package org.exercice.view;

import org.exercice.model.Spectacle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SpectacleFormView extends JDialog {

    private Spectacle spectacle = new Spectacle();
    private JPanel content;
    public SpectacleFormView(JFrame frame, Spectacle spectacle){
        super(frame);
        this.spectacle = spectacle;
        this.init();
        this.populate();
    }

    private void init(){
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.content = new JPanel(new GridLayout(4,2));
        this.setTitle("Ajouter - modifier un spectacle");
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(600,400));
        JLabel titre = new JLabel("Modifier / Ajouter un spectacle");
        this.add(titre, BorderLayout.NORTH);
        this.add(this.content);
        JButton valider = new JButton("Valider");
        valider.addActionListener(this::validate);
        this.add(valider, BorderLayout.SOUTH);

    }

    private void validate(ActionEvent event) {
        System.out.println("button validate clicked");
    }

    private void populate() {
        JLabel descriptionLabel = new JLabel("Description");
        JTextField descriptionField = new JTextField(spectacle.getDescription());
        this.content.add(descriptionLabel);
        this.content.add(descriptionField);

    }


}
