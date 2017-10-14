package burp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class SimpleBurpTab implements ITab {

    private static final String TAB_TITLE = "Mi nuevo Tab";
    private static final String BUTTON_LABEL = "Soy un boton de ejemplo";

    private IBurpExtenderCallbacks callbacks;
    private PrintWriter stdout = null;

    public SimpleBurpTab(IBurpExtenderCallbacks callbacks, PrintWriter stdout) {
        this.callbacks = callbacks;
        this.stdout = stdout;
    }

    @Override
    public String getTabCaption() {
        return TAB_TITLE;
    }

    @Override
    public Component getUiComponent() {
        //objetos de awt
        Panel panel = new Panel();
        //color
        panel.setBackground(Color.RED);

        Button button = new Button(BUTTON_LABEL);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stdout.println("boton presionado");
                JOptionPane.showMessageDialog(null, "Hola Burp", "Burp: " + "Test", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(button);
        callbacks.customizeUiComponent(panel);
        return panel;
    }
}

