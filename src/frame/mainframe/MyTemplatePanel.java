package frame.mainframe;

import frame.*;
import hash.*;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public abstract class MyTemplatePanel extends JPanel implements MyContainable {
    JTextArea inputArea;
    JTextArea outputArea;
    JPanel inputAreaPanel;
    JPanel outputAreaPanel;

    JComboBox<HashFunction> hashComboBox;
    JButton copyToClipboardButton;
    JButton clearButton;

    @Override
    public void createComponents() {
        inputArea = new JTextArea();
        outputArea = new JTextArea();
        inputAreaPanel = new JPanel();
        outputAreaPanel = new JPanel();

        hashComboBox = new JComboBox<>(new HashFunction[] {
                HashFunctions.BINARY_HASH_FUNCTION,
                HashFunctions.QUATERNARY_HASH_FUNCTION,
                HashFunctions.OCTAL_HASH_FUNCTION,
                HashFunctions.DECIMAL_HASH_FUNCTION,
                HashFunctions.HEXADECIMAL_HASH_FUNCTION,
                HashFunctions.TRIACONTAKAIDECIMAL_HASH_FUNCTION});
        copyToClipboardButton = new JButton("Copy Text");
        clearButton = new JButton("Clear");
    }

    @Override
    public void addComponents() {
        JScrollPane inputScrollPane = new JScrollPane(inputArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        inputScrollPane.setPreferredSize(new Dimension(250, 250));

        JScrollPane outputScrollPane = new JScrollPane(outputArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outputScrollPane.setPreferredSize(new Dimension(250, 250));

        MyFrameTools.addComponentWithEdgeSpacing(inputAreaPanel, inputScrollPane, 5);
        MyFrameTools.addComponentWithEdgeSpacing(outputAreaPanel, outputScrollPane, 5);
    }

    @Override
    public void bindActions() {
        copyToClipboardButton.addActionListener(e -> {
            StringSelection stringSelection = new StringSelection(outputArea.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        });
        clearButton.addActionListener(e -> {
            outputArea.setText("");
            inputArea.setText("");
        });
    }

    @Override
    public void configureSettings() {
        inputArea.setFont(MyFonts.ARIAL_UNICODE_14);
        inputArea.setLineWrap(true);

        outputArea.setFont(MyFonts.ARIAL_UNICODE_14);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);

        inputAreaPanel.setBorder(MyFrameTools.createMyTitledBorder("Input"));
        outputAreaPanel.setBorder(MyFrameTools.createMyTitledBorder("Output"));
    }
}
