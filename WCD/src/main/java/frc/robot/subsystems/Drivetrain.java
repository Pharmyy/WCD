package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.utils.RobotState;

public class Drivetrain {
    private TalonFX _leftMaster;
    private TalonFX _rightMaster;

    public Drivetrain(TalonFX leftMaster, TalonFX rightMaster) {
        _leftMaster = leftMaster;
        _rightMaster = rightMaster;
    }

    public void operate(RobotState joysticks) {
        /* Check if we should reset sensors */
        if (joysticks.clearSensors) {
            _leftMaster.getSensorCollection().setIntegratedSensorPosition(0, 0);
            _rightMaster.getSensorCollection().setIntegratedSensorPosition(0, 0);
        }

        switch (joysticks.driveTrainState.state) {
            case PercentOut:
                _leftMaster.set(TalonFXControlMode.PercentOutput, joysticks.driveTrainState.leftSide);
                _rightMaster.set(TalonFXControlMode.PercentOutput, joysticks.driveTrainState.rightSide);
                break;
            case Position:
                break;
            case MotionMagic:
                _leftMaster.follow(_rightMaster, FollowerType.AuxOutput1);
                _rightMaster.set(
                        TalonFXControlMode.MotionMagic,
                        joysticks.driveTrainState.rightSide,
                        DemandType.AuxPID,
                        joysticks.driveTrainState.leftSide);
                break;
        }
    }
}