package NPChierarchy;

import java.util.Objects;

import otherClasses.City;

public class NPC
{
	protected String name;
	protected City city;

	public NPC(String name, City city)
	{
		this.name = name;
		this.city = city;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public City getCity()
	{
		return city;
	}

	public void setCity(City city)
	{
		this.city = city;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NPC other = (NPC) obj;
		return Objects.equals(city, other.city) && Objects.equals(name, other.name);
	}
}
