package cn.zyf.mybatis;

public class Entity {
    private Integer id;

    private Integer nums;

    private String name;

    public Entity(Integer id, Integer nums, String name) {
        this.id = id;
        this.nums = nums;
        this.name = name;
    }

    public Entity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "Entity [id=" + id + ", nums=" + nums + ", name=" + name + "]";
	}
    
    
}