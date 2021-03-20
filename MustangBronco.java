import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MustangBronco {


    //Min/Max for the randomize function
    private static int maxRand = 1000;
    private static int minRand = -1000;

    //Delay between each test
    private static int delaySeconds = 2;

    //Values to be tested
    private static int[] testValues = {2, 6, 10, 15};

    public static void main(String args[])
    {
        GUI application = new GUI();

        JTextField text = application.getInput();


        //System for updating output
        text.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }

            private void update()
            {
                application.setOutput(recalculate(text));
            }
        });

        //Randomizer system
        application.getRandom().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rand = (int) (Math.random() * (maxRand - minRand+  1) ) + minRand;
                application.setInput(String.valueOf(rand));
            }
        });


        //Timer and listener for testing
        Timer testerTimer = new Timer(delaySeconds * 1000, null);
        testerTimer.addActionListener(new ActionListener() {

            int testIndex = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                application.setInput(String.valueOf(testValues[testIndex]));
                testIndex++;

                //Testing has concluded
                if(testIndex == testValues.length){
                    testerTimer.stop();
                    testIndex = 0;

                    application.getTester().setEnabled(true);
                    application.getRandom().setEnabled(true);
                }
            }
        });

        //"Automatic" testing system
        application.getTester().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                application.getTester().setEnabled(false);
                application.getRandom().setEnabled(false);

                application.setOutput("You should see 2, Mustang, Bronco, MustangBronco");
                testerTimer.setRepeats(true);
                testerTimer.start();
            }
        });



    }

    private static String recalculate(JTextField text){
        try
        {
            int parsedInt = Integer.parseInt(text.getText());
            StringBuilder output = new StringBuilder();
            if(parsedInt % 3 == 0)
            {
                //number is divisible by 3
                output.append("Mustang");
            }

            if(parsedInt % 5 == 0){
                //number is divisible by 5
                output.append("Bronco");
            }

            if(output.length() == 0)
            {
                //If output is empty at this point, we know
                //the number is not divisible by 3 or 5
                output.append(parsedInt);
            }

            return output.toString();
        }
        catch(NumberFormatException e){
            //input not valid
            return "Not a valid integer!";
        }
    }
}
