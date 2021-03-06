package tw.edu.ncu.softwareengineering.dodoio.Collide;

import tw.edu.ncu.softwareengineering.dodoio.CollideObject.Position;

public class RectangleCollider extends Collider {
    private Point[] points = new Point[4];

    /**
     * Create a rotated RectangleCollider
     *
     * @param position the position of the collider
     * @param width    the width of the collider
     * @param height   the height of the collider
     */
    public RectangleCollider(Position position, int width, int height) {
        super();
        this.position.setPosition(position.getX(), position.getY(), position.getDirection());
        points[0] = rotatePoint(new Point(position.getX() - width / 2, position.getY() - height / 2), 2 * Math.PI * position.getDirection());
        points[1] = rotatePoint(new Point(position.getX() - width / 2, position.getY() + height / 2), 2 * Math.PI * position.getDirection());
        points[2] = rotatePoint(new Point(position.getX() + width / 2, position.getY() + height / 2), 2 * Math.PI * position.getDirection());
        points[3] = rotatePoint(new Point(position.getX() + width / 2, position.getY() - height / 2), 2 * Math.PI * position.getDirection());
    }

    /**
     * @return the point array of the collider
     */
    public Point[] getPoints() {
        return points;
    }

    @Override
    public void update(Position position) {
        int xOffset = position.getX() - this.position.getX();
        int yOffset = position.getY() - this.position.getY();
        for (Point point : points) {
            point.x += xOffset;
            point.y += yOffset;
        }
        this.position.setPosition(position.getX(), position.getY(), position.getDirection());
    }

    /**
     * Rotate a point with angle
     *
     * @param p     point to be rotated
     * @param angle rotate angle, in radian
     * @return a rotated point
     */
    private Point rotatePoint(Point p, double angle) {
        //change origin to current position
        double x = p.x - position.getX();
        double y = p.y - position.getY();
        //multiply rotate matrix
        double mx = Math.round(Math.cos(angle) * x - Math.sin(angle) * y);
        double my = Math.round(Math.sin(angle) * x + Math.cos(angle) * y);
        //change origin to 0,0
        mx += position.getX();
        my += position.getY();
        return new Point(mx, my);
    }
}
