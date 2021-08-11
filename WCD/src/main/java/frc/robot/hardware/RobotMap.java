package frc.robot.hardware;

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.Joystick;

public class RobotMap {
    /* Drivetrain */
    public static TalonFX leftMaster;
    public static TalonFX leftSlave;
    public static TalonFX leftSlave1;
    public static TalonFX rightMaster;
    public static TalonFX rightSlave;
    public static TalonFX rightSlave2;

    /* Assigned Driver Joystick */
    public static Joystick driverJoystick;

    public static void initialize() {
        /* Drivetrain Falcons */
        leftMaster = new TalonFX(0);
        leftSlave = new TalonFX(1);
        leftSlave1 = new TalonFX(2);
        rightMaster = new TalonFX(3);
        rightSlave = new TalonFX(4);
        rightSlave2 = new TalonFX(5);
        
        /* Drive Joystick */
        driverJoystick = new Joystick(0);

        configControllers();
    }

    private static void configControllers() {
        LeftDriveConfigs.configSide(leftMaster, leftSlave, leftSlave1);
        RightDriveConfigs.configSide(rightMaster, rightSlave, rightSlave2, leftMaster);
    }
}