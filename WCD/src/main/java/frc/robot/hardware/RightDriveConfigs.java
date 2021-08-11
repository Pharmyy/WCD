package frc.robot.hardware;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;

public class RightDriveConfigs {
    public static void configSide(
            TalonFX master, TalonFX slave, TalonFX slave2, TalonFX leftMaster) {
        TalonFXConfiguration masterConfigs = new TalonFXConfiguration();

        masterConfigs.slot0.kP = 2;
        masterConfigs.slot0.kD = 5;
        masterConfigs.slot0.kF = 0.37749077490774907749077490774908;
        masterConfigs.slot1.kP = 3;
        masterConfigs.slot1.kD = 50;

        masterConfigs.primaryPID.selectedFeedbackSensor = FeedbackDevice.IntegratedSensor;

        masterConfigs.motionCruiseVelocity = 1800;
        masterConfigs.motionAcceleration = 3000;

        master.configAllSettings(masterConfigs);
        master.setInverted(true);
        master.setNeutralMode(NeutralMode.Brake);
        master.setSensorPhase(true);
        master.selectProfileSlot(1, 1);

        TalonFXConfiguration slaveConfigs = new TalonFXConfiguration();
         /* Third Falcon and Second Slave??? */
        TalonFXConfiguration slave2Configs = new TalonFXConfiguration();

        /* First slave */
        slave.configAllSettings(slaveConfigs);
        slave.follow(master);
        slave.setInverted(TalonFXInvertType.FollowMaster);
        slave.setNeutralMode(NeutralMode.Brake);

        
         /* Third Falcon and Second Slave??? */
        slave2.configAllSettings(slave2Configs);

        slave2.follow(master);
        slave2.setInverted(TalonFXInvertType.FollowMaster);
        slave2.setNeutralMode(NeutralMode.Brake);
        
    }
}