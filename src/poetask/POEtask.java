package poetask;

import javax.swing.*;

public class POEtask {

    public static void main(String[] args) {
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        login obj = new login();
        obj.menu();
    }
}
