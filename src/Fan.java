public class Fan {

    int speed = 0;
    Direction direction = Direction.Forward;

    public void pull()
    {
        if (speed == 3)
        {
            speed = 0;
            direction = Direction.Forward;
        }
        else
        {
            speed++;
        }
    }

    public void reverse()
    {
        if (direction.equals(Direction.Forward))
        {
            direction = Direction.Backward;
        }
        else
        {
            direction = Direction.Forward;
        }
    }

    public Direction getDirection()
    {
        return direction;
    }

    public int getSpeed()
    {
        return speed;
    }

    public String toString()
    {
        return String.format("Current speed: %s, Current Direction: %s",(speed==0)?"OFF":speed,direction);
    }
}

enum Direction
{
    Forward,
    Backward;
}

