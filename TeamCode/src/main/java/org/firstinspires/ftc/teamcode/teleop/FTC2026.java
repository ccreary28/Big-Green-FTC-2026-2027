package org.firstinspires.ftc.teamcode.teleop;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="FTC2026", group="TeleOp")
public class FTC2026 extends OpMode {
    private DcMotor frontLeft, frontRight, backLeft, backRight, intake, shooter;
    private Servo servo;

    @Override
    public void init() {

        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        intake = hardwareMap.get(DcMotor.class, "intake");
        shooter = hardwareMap.get(DcMotor.class, "shooter");

        servo = hardwareMap.get(Servo.class, "servo");
        servo.setPosition(1);

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Initialization", "successful!");
        telemetry.addLine(" ");
        telemetry.addLine("Use the Left Joystick to drive");
        telemetry.addLine("Moving the Right Joystick turns the robot's direction");
        telemetry.addLine("Press ⏶ to intake");
        telemetry.addLine("Press X to outtake");


        telemetry.addLine("GO BIG GREEN!!! ദ്ദി(｡•̀ ,<)");
        telemetry.update();

    }
    @Override
    public void loop() {

        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        double frontLeftPower  = y + x + rx;
        double backLeftPower   = y - x + rx;
        double frontRightPower = y - x - rx;
        double backRightPower  = y + x - rx;
        double max = Math.max(1.0, Math.max(
                Math.abs(frontLeftPower),
                Math.max(Math.abs(backLeftPower),
                        Math.max(Math.abs(frontRightPower), Math.abs(backRightPower)))));

        if (gamepad1.x) {
            intake.setPower(1);
        } else intake.setPower(0);

        if (gamepad1.y) {
            intake.setPower(-1);
        } else intake.setPower(0);

        if (gamepad1.a) {
            shooter.setPower(0.57);
        }

        if (gamepad1.b) {
            servo.setPosition(0.8);
        } else servo.setPosition(1);

        frontLeft.setPower(frontLeftPower / max);
        backLeft.setPower(backLeftPower / max);
        frontRight.setPower(frontRightPower / max);
        backRight.setPower(backRightPower / max);

    }

}