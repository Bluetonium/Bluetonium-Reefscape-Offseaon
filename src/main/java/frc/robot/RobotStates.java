package frc.robot;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.driver.Drivers;

public class RobotStates {

    // elevtor
    public static Trigger home;
    public static Trigger intakePosition;
    public static Trigger L1;
    public static Trigger L2;
    public static Trigger L3;
    public static Trigger algaeRemove;

    public static void setupStates() {
        home = Drivers.home;
        intakePosition = Drivers.intakePosition;
        L1 = Drivers.L1;
        L2 = Drivers.L2;
        L3 = Drivers.L3;
        algaeRemove = Drivers.algaeRemove;

    }
}
