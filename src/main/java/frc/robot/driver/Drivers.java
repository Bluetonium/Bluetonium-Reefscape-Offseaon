package frc.robot.driver;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class Drivers {
    public static class DriverConfigs {
        public int port = 0;
        public boolean elevatorControl = false;
        public boolean chassisDriving = false;
        public boolean outtakeControl = false;
    }

    // elevator
    public static DoubleSupplier elevatorAdjustment;
    // Chassis
    public static DoubleSupplier chassisControlTranslation;
    public static DoubleSupplier chassisControlStrafe;
    public static DoubleSupplier chassisControlRotation;
    public static DoubleSupplier pov;

    public static Trigger wheelsXPosition;
    public static Trigger steerWheels;
    public static Trigger zeroHeading;
    public static Trigger reefAlignLeft;
    public static Trigger reefAlignRight;
    public static Trigger coralStationAlign;
    public static Trigger microAdjust;
    public static Trigger triggerMicroAdjust;

    private final XboxController controller;

    public static Trigger home;
    public static Trigger intakePosition;
    public static Trigger L1;
    public static Trigger L2;
    public static Trigger L3;
    public static Trigger algaeRemove;

    // Outtake
    public static Trigger intake;
    public static Trigger outtake;

    private void applyConfigs(DriverConfigs configs) {
        if (configs.chassisDriving) {

            // dpad micro adjustments

            chassisControlTranslation = controller::getLeftY;
            chassisControlStrafe = controller::getLeftX;
            chassisControlRotation = controller::getRightX;
            pov = controller::getPOV;

            wheelsXPosition = new Trigger(controller::getXButton);
            steerWheels = new Trigger(controller::getAButton);
            zeroHeading = new Trigger(controller::getBButton);
            reefAlignLeft = new Trigger(controller::getLeftBumperButton);
            reefAlignRight = new Trigger(controller::getRightBumperButton);
            coralStationAlign = new Trigger(controller::getYButton);
            microAdjust = new Trigger(() -> controller.getPOV() != -1); // splendid
            // triggerMicroAdjust = new Trigger(controller::getAButton);
            triggerMicroAdjust = new Trigger(() -> controller.getRightTriggerAxis() > 0.5);
        }

        if (configs.elevatorControl) {
            elevatorAdjustment = controller::getLeftY;
            home = new Trigger(controller::getYButton);
            intakePosition = new Trigger(controller::getLeftBumperButton);
            L1 = new Trigger(() -> controller.getPOV() == 0);
            L2 = new Trigger(() -> controller.getPOV() == 90);
            L3 = new Trigger(() -> controller.getPOV() == 180);
            algaeRemove = new Trigger(() -> controller.getPOV() == 270);
        }

        if (configs.outtakeControl) {
            intake = new Trigger(controller::getAButton);
            outtake = new Trigger(controller::getBButton);
        }
    }

    public Drivers(DriverConfigs driverConfigs) {
        controller = new XboxController(driverConfigs.port);
        applyConfigs(driverConfigs);
    }
}
