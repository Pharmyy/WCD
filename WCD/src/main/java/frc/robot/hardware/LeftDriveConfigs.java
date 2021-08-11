package frc.robot.hardware;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;

public class LeftDriveConfigs {

    public static void configSide(TalonFX master, TalonFX slave, TalonFX slave1) {
        TalonFXConfiguration masterConfigs = new TalonFXConfiguration();

        master.configAllSettings(masterConfigs);
        master.setInverted(false);
        master.setNeutralMode(NeutralMode.Brake);
        master.setSensorPhase(true);

        TalonFXConfiguration slaveConfigs = new TalonFXConfiguration();
        /* Third Falcon and Second Slave??? */
        TalonFXConfiguration slave1Configs = new TalonFXConfiguration();
    
        /* First slave */
        slave.configAllSettings(slaveConfigs);
        slave.follow(master);
        slave.setInverted(TalonFXInvertType.FollowMaster);
        slave.setNeutralMode(NeutralMode.Brake);

         /* Third Falcon and Second Slave??? */
        slave1.configAllSettings(slave1Configs);

        slave1.follow(master);
        slave1.setInverted(TalonFXInvertType.FollowMaster);
        slave1.setNeutralMode(NeutralMode.Brake);
        
    }
}