template <typename T>
class Game
{
    T& crtp_cast() { return *static_cast<T*>(this); }
    const T& crtp_cast() const { return *static_cast<const T*>(this); }
public:
    T copy() const { return crtp_cast(); }
    int cur_player() const { return crtp_cast().cur_player(); }
    ...
};