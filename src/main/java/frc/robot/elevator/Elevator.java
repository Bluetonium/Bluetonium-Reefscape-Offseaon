package frc.robot.elevator;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    private TalonFX motor;
    private TalonFXConfiguration config;

    public Elevator() {

    }
}
