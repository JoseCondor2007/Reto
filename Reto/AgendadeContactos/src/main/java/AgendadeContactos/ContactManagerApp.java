package AgendadeContactos;


import javax.swing.*;
import java.awt.*;

public class ContactManagerApp extends JFrame {

    private ContactInputPanel inputPanel;
    private ContactListPanel listPanel;
    private ContactInfoPanel infoPanel;

    public ContactManagerApp() {
        setTitle("Administrador de Contactos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Initialize panels
        inputPanel = new ContactInputPanel();
        listPanel = new ContactListPanel();
        infoPanel = new ContactInfoPanel();

        // Set layout for the main frame
        setLayout(new BorderLayout());

        // Add panels to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(listPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
