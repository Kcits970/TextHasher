package frame.mainframe;

import frame.MyFrameTools;
import hash.HashFunction;
import hash.UnhashException;
import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class UnhashTab extends MyTemplatePanel {
	JButton unhashButton;

	public UnhashTab() {
		build();
	}

	@Override
	public void createComponents() {
		super.createComponents();

		unhashButton = new JButton("Unhash!");
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
		c.add(MyFrameTools.addHorizontally(null, false,
				hashComboBox, unhashButton, copyToClipboardButton, clearButton), constraints);

		MyFrameTools.addComponentWithEdgeSpacing(this, c, 5);
	}

	@Override
	public void bindActions() {
		super.bindActions();

		hashComboBox.addItemListener(e -> Settings.unhashFunction = (HashFunction) hashComboBox.getSelectedItem());
		unhashButton.addActionListener(e -> {
			try {
				outputArea.setText(Settings.unhashFunction.unhash(inputArea.getText()));
			} catch (UnhashException ex) {
				outputArea.setText("NULL");
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}