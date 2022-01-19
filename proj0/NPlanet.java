public class NPlanet{
	public static double readRadius(String path) {
        In in = new In(path);
        in.readInt();
        return in.readDouble();
    }
    /**In  just not working so I stop here. */
}