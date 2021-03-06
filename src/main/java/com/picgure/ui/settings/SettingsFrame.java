package com.picgure.ui.settings;

import javax.swing.*;

/*
 * @author Jeet Prakash
 * */
public class SettingsFrame extends JFrame {

    private SettingsInputPanel settingsInputPanel;

    public SettingsFrame() {
        this.settingsInputPanel = new SettingsInputPanel();
        createFrame();
    }

    private void createFrame() {
        this.setTitle("Settings");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(450, 300);
        this.setResizable(false);
        this.add(this.settingsInputPanel);
    }

    public void loadSettings() {
        this.settingsInputPanel.loadSettings();
    }

}
