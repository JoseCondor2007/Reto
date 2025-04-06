package AgendadeContactos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ContactInfoPanel extends JPanel {

    private static JLabel lblInfo;

    public ContactInfoPanel() {
        setLayout(new BorderLayout());
        lblInfo = new JLabel("Gestiona tus contactos facilmente");
        lblInfo.setBorder(new EmptyBorder(15, 0, 15, 0));
        lblInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblInfo, BorderLayout.CENTER);
    }

    public static void actualizarInfo(String info) {
        //  int totalContacts = ContactListPanel.getContactCount(); //  Este método no existe
        //  lblInfo.setText("Total de Contactos" + totalContacts);
        lblInfo.setText(info); //  Update the label with the provided info
    }
}