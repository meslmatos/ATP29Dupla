package modells;

public abstract class Base {
    public int id;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Base){
            Base comparar = (Base)obj;
            if(this.id==comparar.id){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Id: "+this.id;
    }
}
