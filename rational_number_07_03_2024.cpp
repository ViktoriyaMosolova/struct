#include <iostream>
class Test {
    public:

    int chislitel;
    int znamenatel;

    Test(int a, int b) {
        chislitel = a / getDelitel(a, b);
        znamenatel = b / getDelitel(a, b);
    }

    int getDelitel(int a, int b) {
        return b ? getDelitel(b, a % b) : a;       
    }

};

int main() {
    int a = 30;
    int b = 20;
    Test t(a, b);
    std::cout << a << "/" << b << std::endl; 
    std::cout << t.chislitel << "/" << t.znamenatel << std::endl; 
    return 0;
}