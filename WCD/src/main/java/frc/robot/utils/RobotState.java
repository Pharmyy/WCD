package frc.robot.utils;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.FortKnox.FortKnoxState;
import frc.robot.hardware.RobotMap;

public class RobotState {

    public enum DriveTrainState {
        PercentOut,
        Position,
        MotionMagic,
    }

    public class DTStruct {
        public DriveTrainState state;
        public double leftSide;
        public double rightSide;

        @Override
        public String toString() {
            return state.toString() + "  " + leftSide + " " + rightSide;
        }

        public void set(DriveTrainState state, double left, double right) {
            this.state = state;
            leftSide = left;
            rightSide = right;
        }
    }
    ;

    public DTStruct driveTrainState;

    public boolean clearSensors;

    private Joystick _driver;

    public RobotState(Joystick driver) {
        _driver = driver;

        /* Initialize states */
        driveTrainState = new DTStruct();
        /*Do we need to clear sensors? No */
        clearSensors = false;
    }

    public void getJoystickValues() {
        /* Drive base */
        double ratio;
        if (_driver.getRawButton(6)) {
            ratio = 0.2;
        } else {
            ratio = 0.4;
        }

        double throt = -_driver.getRawAxis(1); /* Throttle Forward */
        double wheel = _driver.getRawAxis(4) * ratio; /* Throttle is negated */
        double leftSide = throt + wheel; 
        double rightSide = throt - wheel;

        driveTrainState.set(DriveTrainState.PercentOut, leftSide, rightSide);
    }
}