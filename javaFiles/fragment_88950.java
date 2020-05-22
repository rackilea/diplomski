template<typename Game> void f(const Game& g) {
    std::cout << g.cur_player();
}
class X {
public:
    int cur_player() const { return 1; }
};
class Y {
public:
    int cur_player() const { return 2; }
};
int main() {
    f(X());
    f(Y());
}