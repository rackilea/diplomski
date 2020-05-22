public void initVelocityConstraints(final SolverData data) {

    // some code...

    float mass = m_bodyB.getMass();

    // Frequency
    float omega = 2.0f * MathUtils.PI * m_frequencyHz;

    // Damping coefficient
    float d = 2.0f * mass * m_dampingRatio * omega;

    // Spring stiffness
    float k = mass * (omega * omega);

    // magic formulas
    // gamma has units of inverse mass.
    // beta has units of inverse time.
    float h = data.step.dt;
    assert (d + h * k > Settings.EPSILON);

    // some code...

}