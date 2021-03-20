import javax.swing.*;
import java.awt.*;

public class GUI {

    private static final int FONTSIZE = 20;

    //font used by components
    private static final Font FONT = new Font(Font.SANS_SERIF, Font.PLAIN, FONTSIZE);

    private JFrame frame;
    private JTextField input;
    private JLabel output;
    private JLabel caption;
    private JButton random;
    private JButton tester;

    public GUI()
    {
        frame = new JFrame();
        caption = new JLabel("Input a number below!");
        input = new JTextField();
        output = new JLabel("Awaiting Input");
        random = new JButton("Randomize");
        tester = new JButton("Test");


        //Set appearance of GUI
        frame.setLayout(null);
        frame.setBounds(0,0,600,200);
        caption.setBounds(10,10,200,FONTSIZE + 10);
        input.setBounds(10,20 + FONTSIZE,200,FONTSIZE + 10);
        output.setBounds(10,100 + FONTSIZE,550,FONTSIZE + 10);
        random.setBounds(240,20 + FONTSIZE,200,FONTSIZE + 10);
        tester.setBounds(240,2 * (20 + FONTSIZE),200,FONTSIZE + 10);


        //Add elements to the GUI
        frame.add(caption);
        frame.add(input);
        frame.add(output);
        frame.add(random);
        frame.add(tester);
        frame.setTitle("Mustang Bronco");

        setFonts(frame);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }


    private static void setFonts(JFrame frame)
    {
        //Set font for all components
        for(Component component : frame.getContentPane().getComponents())
        {
            component.setFont(FONT);
        }
    }

    public void setOutput(String text)
    {
        output.setText(text);
    }

    public void setInput(String text) { input.setText(text); }

    public JTextField getInput()
    {
        return input;
    }

    public JButton getRandom(){
        return random;
    }

    public JButton getTester(){
        return tester;
    }

}
