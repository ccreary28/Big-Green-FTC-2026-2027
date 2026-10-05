package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous(name="LeaveParkAuto", group="Autonomous")
public class LeaveParkAuto extends LinearOpMode {
    private DcMotor frontLeft, frontRight, backLeft, backRight;
    @Override
    public void runOpMode() {
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        if (opModeIsActive()) {

            // go forward
            frontLeft.setPower(0.4);
            backLeft.setPower(0.4);
            frontRight.setPower(0.4);
            backRight.setPower(0.4);

            // pausing to adjust
            sleep(1000);

            //going into parking zone
            frontLeft.setPower(-0.5);
            backLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backRight.setPower(-0.5);

            // pausing to adjust
            sleep(900);

            // go down
            frontLeft.setPower(-0.4);
            backLeft.setPower(-0.4);
            frontRight.setPower(-0.4);
            backRight.setPower(-0.4);

            // pausing to adjust
            sleep(850);

            // stopping
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);

        }


    }
}


