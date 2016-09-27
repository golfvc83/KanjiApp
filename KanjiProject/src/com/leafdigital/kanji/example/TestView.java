package com.leafdigital.kanji.example;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class TestView extends JFrame implements ActionListener
{
    private JButton btn;

    public TestView()
    {
        super("Simple GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn = new JButton("Open the other JFrame!");
        btn.addActionListener(this);
        btn.setActionCommand("Open");
        add(btn);
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();

        if(cmd.equals("Open"))
        {
            dispose();
            try {
				new ExampleApp("Test");
			} catch (FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run()
            {
                new TestView().setVisible(true);
            }

        });
    }
}