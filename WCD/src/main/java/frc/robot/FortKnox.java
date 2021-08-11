package frc.robot;

import frc.robot.hardware.RobotMap;
import frc.robot.subsystems.*;
import frc.robot.utils.RobotState;

public class FortKnox {
    public enum FortKnoxState {
        Disabled,
        Teleoperated,
        Autonomous,
        Test,
    };

    private FortKnoxState _currentState;
    private Drivetrain _drivetrain;
    private RobotState _robot;

    public FortKnox() {
        RobotMap.initialize();

        _drivetrain = new Drivetrain(RobotMap.leftMaster, RobotMap.rightMaster);
        _robot = new RobotState(RobotMap.driverJoystick);
        _currentState = FortKnoxState.Disabled;
    }

    public void periodicTasks() {
        _robot.getJoystickValues();

        switch (_currentState) {
            case Autonomous:
            case Teleoperated:
            case Disabled:
                /* Listen to joysticks and run our mechanisms */
                _drivetrain.operate(_robot);

            case Test:
                /* Test does its own stuff */
                break;
        }
        if (_currentState == FortKnoxState.Disabled) {;
        }
    }

    public void changeState(FortKnoxState newState) {
        _currentState = newState;
    }
}