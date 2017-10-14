package burp;

import java.io.PrintWriter;

/**
 * Ejemplo de prueba de BurpExtender
 */
public class BurpExtender implements IBurpExtender {

    private static final String EXT_NAME = "Hola Burp";
    private static final String ALERT = "Alerta!, Hola Burp!";

    private IBurpExtenderCallbacks callbacks;
    private IExtensionHelpers helpers;
    private PrintWriter stdout = null;
    private PrintWriter stderr = null;


    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        helpers = callbacks.getHelpers();
        //nombre de la extension
        callbacks.setExtensionName(EXT_NAME);
        stdout = new PrintWriter(callbacks.getStdout(), true);
        stderr = new PrintWriter(callbacks.getStderr(), true);


        stdout.println("Hola Burp --> StdOut");
        stderr.println("Hola Burp --> StdErr");

        //tab de alertas
        callbacks.issueAlert(ALERT);

        //agrego un tab
        callbacks.addSuiteTab(new SimpleBurpTab(callbacks, stdout));
    }
}
