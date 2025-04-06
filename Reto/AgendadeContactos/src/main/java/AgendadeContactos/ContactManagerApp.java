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


        inputPanel = new ContactInputPanel();
        listPanel = new ContactListPanel();
        infoPanel = new ContactInfoPanel();


        setLayout(new BorderLayout());


        add(inputPanel, BorderLayout.NORTH);
        add(listPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
