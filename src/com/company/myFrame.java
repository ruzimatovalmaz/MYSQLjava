package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class myFrame extends JFrame implements ActionListener{
    private JPanel mainPanel;
    private JTextField inputFirstName;
    private JTextField inputLastName;
    private JButton submitButton;
    private JButton updateButton;
    private JTextArea showData;
    private JScrollPane scrollPane;
    private JPanel innerPanel;

    public myFrame()
    {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        createComponents();
        getContentPane().setBackground(Color.CYAN);
    }


    public void createComponents() {
        mainPanel = new JPanel(new GridLayout(3, 1));
        inputFirstName = new JTextField();
        inputLastName = new JTextField();
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        showData = new JTextArea();
        showData.setEditable(false);
        scrollPane = new JScrollPane(showData);
        innerPanel = new JPanel(new GridLayout(1,2));
        JPanel innerInputPanel = new JPanel(new GridLayout(4,1));
        innerInputPanel.add(new JLabel("Please enter the First name bellow:"));
        innerInputPanel.add(inputFirstName);
        innerInputPanel.add(new JLabel("Please enter the Last name bellow:"));
        innerInputPanel.add(inputLastName);
        innerPanel.add(submitButton);
        innerPanel.add(updateButton);
        mainPanel.add(scrollPane);
        mainPanel.add(innerInputPanel);
        mainPanel.add(innerPanel);
        add(mainPanel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == updateButton)
       {
           ArrayList<String> name = new ArrayList<>(Main.sqlUpdate());
            showData.removeAll();
            for(int i =0; i < name.size();i++)
            {
                showData.append(name.get(i)+"\n");
            }
       }
       if(e.getSource() == submitButton)
       {
           String fName = inputFirstName.getText().toUpperCase().toString();
           String lName = inputLastName.getText().toUpperCase().toString();
           Main.insertDataSql(fName,lName);
           inputFirstName.setText("");
           inputLastName.setText("");
       }


    }

}
