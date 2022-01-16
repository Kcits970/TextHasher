package frame.mainframe;

import frame.MyFrameTools;
import hash.HashFunction;
import settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class HashTab extends MyTemplatePanel {
	JCheckBox includeSpaceCheckBox;
	JCheckBox capitalizeCheckBox;
	JButton hashButton;

	public HashTab() {
		build();
	}

	@Override
	public void createComponents() {
		super.createComponents();

		includeSpaceCheckBox = new JCheckBox("Include Space");
		capitalizeCheckBox = new JCheckBox("Capitalize Letters");
		hashButton = new JButton("Hash!");
	}

	@Override
	public void addComponents() {
		super.addComponents();

		Container c = new Container();
		c.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5,5,5,5);

		constraints.gridx = 0;
		constraints.gridy = 0;
		c.add(inputAreaPanel, constraints);

		constraints.gridx = 1;
		c.add(outputAreaPanel, constraints);

		constraints.gridy = 1;
		constraints.gridx = 0;
		constraints.gridwidth = 2;
		c.add(MyFrameTools.addHorizontally(null, false, hashComboBox, includeSpaceCheckBox, capitalizeCheckBox), constraints);

		constraints.gridy = 2;
		c.add(MyFrameTools.addHorizontally(null, false, hashButton, copyToClipboardButton, clearButton), constraints);

		MyFrameTools.addComponentWithEdgeSpacing(this, c, 5);
	}

	@Override
	public void bindActions() {
		super.bindActions();

		hashComboBox.addItemListener(e -> Settings.hashFunction = (HashFunction) hashComboBox.getSelectedItem());
		includeSpaceCheckBox.addItemListener(e -> Settings.includeSpace = !Settings.includeSpace);
		capitalizeCheckBox.addItemListener(e -> Settings.capitalize = !Settings.capitalize);

		hashButton.addActionListener(e -> {
			String outputText =  Settings.hashFunction.hash(inputArea.getText());
			if (Settings.capitalize) outputText = outputText.toUpperCase(Locale.ROOT);
			outputArea.setText(outputText);
		});
	}
}