package br.ufc.quixada.qxd0010;

// FIXME: Lidar com "índices" negativos
class ArrayList {
    protected int[] vector; // vetor
    protected int size; // tamanho
    protected int capacity; // capacidade

    public ArrayList() {
        this.vector = null;
        this.capacity = 0;
        this.size = 0;
    }

    // FIXME: Versão que recebe parâmetro
    private void increase_capacity() {
        if (this.capacity == 0) {
            this.vector = new int[2];
            this.capacity = 2;
        } else {
            int new_capacity = this.capacity * 2;
            int[] new_vector = new int[new_capacity];

            // Cópia manual dos elementos anteriores
            for (int i = 0; i < this.size; i++) {
                new_vector[i] = this.vector[i];
            }

            this.vector = null; // "Desalocar" vetor anterior
            this.vector = new_vector;
            this.capacity = new_capacity;
        }
    }

    // Com deslocamento
    public int remove(int index) throws IndexOutOfBoundsException {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException(index);
        }

        int removed = this.vector[index];

        for (int k = index; index <= this.size - 2; k++) {
            this.vector[k] = this.vector[k + 1];
        }

        this.size--;

        return removed;
    }

    // Com deslocamento
    public void add(int index, int element) throws IndexOutOfBoundsException {
        if (index > this.size) {
            throw new IndexOutOfBoundsException(index);
        }

        // Caso não haja capacidade disponível
        if (this.size == this.capacity) {
            // Dobra a capacidade atual
            this.increase_capacity();
        }

        for (int k = this.size - 1; k >= index; k--) {
            this.vector[k + 1] = this.vector[k];
        }

        this.vector[index] = element;
        this.size++; // Esqueci de adicionar durante a aula!!
    }

    public int get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(index);
        }

        return this.vector[index];
    }

    public int indexOf(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.vector[i] == element) {
                return i;
            }
        }

        return -1;
    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}