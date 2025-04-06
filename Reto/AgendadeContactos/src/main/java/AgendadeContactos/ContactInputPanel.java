package AgendadeContactos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Clase que representa el panel donde se ingresan nuevos contactos
public class ContactInputPanel extends JPanel {

    // Campos de texto para nombre, teléfono y correo
    private JTextField txtName, txtPhoneNumber, txtEmail;
    // Botón para agregar contacto
    private JButton btnAddContact;

    // Constructor del panel de ingreso
    public ContactInputPanel() {
        // Establece el color de fondo del panel
        setBackground(new Color(212, 235, 248));
        // Usa un layout flexible que permite posicionar los elementos en una cuadrícula
        setLayout(new GridBagLayout());

        // Etiquetas descriptivas para cada campo
        JLabel lblName = new JLabel("Nombre: ");
        JLabel lblPhoneNumber = new JLabel("Teléfono: ");
        JLabel lblEmail = new JLabel("Correo electrónico: ");

        // Inicialización de los campos de entrada de texto
        txtName = new JTextField(25);
        txtPhoneNumber = new JTextField(25);
        txtEmail = new JTextField(25);

        // Botón para agregar un nuevo contacto
        btnAddContact = new JButton("Agregar Contacto");
        // Define un tamaño preferido para el botón
        btnAddContact.setPreferredSize(new Dimension(120, 30));

        // Acción al presionar el botón
        btnAddContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene los valores ingresados por el usuario
                String name = txtName.getText();
                String phoneNumber = txtPhoneNumber.getText();
                String email = txtEmail.getText();

                // Validation
                if (isValidName(name) && isValidPhoneNumber(phoneNumber) && isValidEmail(email)) {
                    // Crea un nuevo contacto y lo añade al panel de la lista
                    ContactListPanel.addContact(new Contact(name, phoneNumber, email));
                    // Limpia los campos después de agregar
                    txtName.setText("");
                    txtPhoneNumber.setText("");
                    txtEmail.setText("");
                    ContactInfoPanel.actualizarInfo("Total de Contactos: " + ContactListPanel.getContactCount());
                }
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblPhoneNumber, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtPhoneNumber, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblEmail, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(txtEmail, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(btnAddContact, gbc);
    }

    // Validation methods
    private boolean isValidName(String name) {
        if (name.isEmpty() || !name.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(this, "El nombre no debe contener números ni caracteres especiales.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{9,}")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe contener solo números y tener al menos 9 dígitos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            JOptionPane.showMessageDialog(this, "El correo electrónico debe tener un formato válido (ejemplo: usuario@dominio.com).", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}