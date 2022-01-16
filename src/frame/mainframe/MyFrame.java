package frame.mainframe;

import frame.MyContainable;
import frame.dialogs.AboutDialog;
import frame.mygraphics.ImageCollection;

import javax.swing.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements MyContainable {
	AboutDialog aboutDialog;

	public MyFrame() {
		build();
	}

	@Override
	public void createComponents() {
		aboutDialog = new AboutDialog(this);
	}

	@Override
	public void addComponents() {
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Hash", new HashTab());
		tabbedPane.addTab("Unhash", new UnhashTab());

		this.getContentPane().add(tabbedPane);
		this.setJMenuBar(new MyMenuBar());
	}

	@Override
	public void configureSettings() {
		setIconImage(ImageCollection.TEXTHASHERICON);

		setTitle("TextHasher");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class MyMenuBar extends JMenuBar implements MyContainable {
		JMenuItem exitMenuItem;
		JMenuItem aboutMenuItem;

		public MyMenuBar() {
			build();
		}

		@Override
		public void createComponents() {
			exitMenuItem = new JMenuItem("Exit");
			aboutMenuItem = new JMenuItem("About TextHasher");
		}

		@Override
		public void addComponents() {
			JMenu fileMenu = new JMenu("File");
			fileMenu.add(exitMenuItem);

			JMenu aboutMenu = new JMenu("About");
			aboutMenu.add(aboutMenuItem);

			add(fileMenu);
			add(aboutMenu);
		}

		@Override
		public void bindActions() {
			exitMenuItem.addActionListener(e -> System.exit(0));
			aboutMenuItem.addActionListener(e -> aboutDialog.setVisible(true));
		}

		@Override
		public void configureSettings() {
			exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		}
	}
}